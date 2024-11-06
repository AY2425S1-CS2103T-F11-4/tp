package seedu.address.logic.commands.listingcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AREA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REGION;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.listing.Address;
import seedu.address.model.listing.Area;
import seedu.address.model.listing.Listing;
import seedu.address.model.listing.Price;
import seedu.address.model.listing.Region;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Seller;

/**
 * Edits the details of an existing listing in the system.
 */
public class EditListingCommand extends Command {

    public static final String COMMAND_WORD = "editlisting";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the listing identified "
            + "by the listing name. Buyers cannot be edited using this command. "
            + "Use addlistingbuyers or removelistingbuyers to manage buyers.\n"
            + "Parameters: LISTING_NAME "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_PRICE + "PRICE] "
            + "[" + PREFIX_AREA + "AREA] "
            + "[" + PREFIX_ADDRESS + "ADDRESS] "
            + "[" + PREFIX_REGION + "REGION]...\n"
            + "Example: " + COMMAND_WORD + " ListingName "
            + PREFIX_PRICE + "4500 "
            + PREFIX_AREA + "1200";

    public static final String MESSAGE_EDIT_LISTING_SUCCESS = "Successfully edited listing: %1$s";
    public static final String MESSAGE_DUPLICATE_LISTING = "This listing already exists in the system.";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_INVALID_LISTING_NAME = "The specified listing name is invalid.";

    private final Name listingName;
    private final EditListingDescriptor editListingDescriptor;

    /**
     * @param listingName of the listing in the filtered listing list to edit
     * @param editListingDescriptor details to edit the listing with
     */
    public EditListingCommand(Name listingName, EditListingDescriptor editListingDescriptor) {
        requireNonNull(listingName);
        requireNonNull(editListingDescriptor);

        this.listingName = listingName;
        this.editListingDescriptor = new EditListingDescriptor(editListingDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Listing> lastShownList = model.getFilteredListingList();

        Listing listingToEdit = lastShownList.stream()
                .filter(listing -> listing.getName().equals(listingName))
                .findFirst()
                .orElse(null);

        if (listingToEdit == null) {
            throw new CommandException(MESSAGE_INVALID_LISTING_NAME);
        }

        Optional<Person> seller = editListingDescriptor.getSellerName()
                .flatMap(name -> Optional.ofNullable(model.getPersonByName(name)));
        if (seller.isPresent()) {
            if (!(seller.get() instanceof Seller)) {
                throw new CommandException("The specified person is not a seller.");
            }
        } else if (editListingDescriptor.getSellerName().isPresent()) {
            throw new CommandException("Seller not found in the system.");
        }

        Listing editedListing = createEditedListing(
                listingToEdit,
                editListingDescriptor,
                seller.orElse(listingToEdit.getSeller())
        );

        if (isIdentifierChanged(listingToEdit, editedListing) && model.canEditListing(listingToEdit, editedListing)) {
            throw new CommandException(MESSAGE_DUPLICATE_LISTING);
        }

        model.setListing(listingToEdit, editedListing);
        return new CommandResult(String.format(MESSAGE_EDIT_LISTING_SUCCESS, Messages.format(editedListing)));
    }

    /**
     * Creates and returns a {@code Listing} with the details of {@code listingToEdit}
     * edited with {@code editListingDescriptor}.
     */
    private static Listing createEditedListing(Listing listingToEdit, EditListingDescriptor editListingDescriptor,
                                               Person seller) {
        assert listingToEdit != null;

        Name updatedName = editListingDescriptor.getName().orElse(listingToEdit.getName());
        Price updatedPrice = editListingDescriptor.getPrice().orElse(listingToEdit.getPrice());
        Area updatedArea = editListingDescriptor.getArea().orElse(listingToEdit.getArea());
        Address updatedAddress = editListingDescriptor.getAddress().orElse(listingToEdit.getAddress());
        Region updatedRegion = editListingDescriptor.getRegion().orElse(listingToEdit.getRegion());
        Person updatedSeller = (seller != null) ? seller : listingToEdit.getSeller();

        return new Listing(updatedName, updatedAddress, updatedPrice, updatedArea, updatedRegion,
                updatedSeller, listingToEdit.getBuyers());
    }

    /**
     * Checks if the unique identifiers of a listing, specifically the name or address,
     * have been modified in the edited version.
     *
     * @param listingToEdit The original listing before edits.
     * @param editedListing The listing with potential edits.
     * @return {@code true} if either the name or address of {@code editedListing} differs
     *         from {@code listingToEdit}, indicating that the identifiers have changed.
     *         Returns {@code false} otherwise.
     */
    private static boolean isIdentifierChanged(Listing listingToEdit, Listing editedListing) {
        return !listingToEdit.getAddress().equals(editedListing.getAddress())
                || !listingToEdit.getName().equals(editedListing.getName());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof EditListingCommand otherEditCommand)) {
            return false;
        }

        return listingName.equals(otherEditCommand.listingName)
                && editListingDescriptor.equals(otherEditCommand.editListingDescriptor);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("listingName", listingName)
                .add("editListingDescriptor", editListingDescriptor)
                .toString();
    }

    /**
     * Stores the details to edit the listing with. Each non-empty field value will replace the
     * corresponding field value of the listing.
     */
    public static class EditListingDescriptor {
        private Name name;
        private Price price;
        private Area area;
        private Address address;
        private Region region;
        private Name sellerName;

        public EditListingDescriptor() {}

        /**
         * Copy constructor.
         * Creates an {@code EditListingDescriptor} by copying the details from another descriptor.
         * Each field is copied from the provided {@code toCopy} descriptor.
         *
         * @param toCopy the {@code EditListingDescriptor} to copy from.
         */
        public EditListingDescriptor(EditListingDescriptor toCopy) {
            setName(toCopy.name);
            setPrice(toCopy.price);
            setArea(toCopy.area);
            setAddress(toCopy.address);
            setRegion(toCopy.region);
            setSellerName(toCopy.sellerName);
        }

        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, price, area, address, region, sellerName);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        public Optional<Price> getPrice() {
            return Optional.ofNullable(price);
        }

        public void setArea(Area area) {
            this.area = area;
        }

        public Optional<Area> getArea() {
            return Optional.ofNullable(area);
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        public void setRegion(Region region) {
            this.region = region;
        }

        public Optional<Region> getRegion() {
            return Optional.ofNullable(region);
        }
        public void setSellerName(Name sellerName) {
            this.sellerName = sellerName;
        }

        public Optional<Name> getSellerName() {
            return Optional.ofNullable(sellerName);
        }


        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            if (!(other instanceof EditListingDescriptor)) {
                return false;
            }

            EditListingDescriptor otherDescriptor = (EditListingDescriptor) other;
            return Objects.equals(name, otherDescriptor.name)
                    && Objects.equals(price, otherDescriptor.price)
                    && Objects.equals(area, otherDescriptor.area)
                    && Objects.equals(address, otherDescriptor.address)
                    && Objects.equals(region, otherDescriptor.region)
                    && Objects.equals(sellerName, otherDescriptor.sellerName);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .add("name", name)
                    .add("price", price)
                    .add("area", area)
                    .add("address", address)
                    .add("region", region)
                    .add("seller", sellerName)
                    .toString();
        }
    }
}
