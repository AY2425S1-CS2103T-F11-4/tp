package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AREA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BUYER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REGION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SELLER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.clientcommands.EditClientCommand;
import seedu.address.logic.commands.clientcommands.ShowClientsCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.listingcommands.ShowListingsCommand;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.listing.Listing;
import seedu.address.model.listing.ListingContainsKeywordsPredicate;
import seedu.address.model.person.Name;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";
    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;

    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol

    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final String VALID_NAME_PASIR_RIS = "Pasir Ris Condo";
    public static final String VALID_ADDRESS_PASIR_RIS = "123 Pasir Ris Drive 3";
    public static final String VALID_AREA_PASIR_RIS = "75";
    public static final String VALID_PRICE_PASIR_RIS = "700000";
    public static final String VALID_REGION_PASIR_RIS = "East";
    public static final String VALID_SELLER_PASIR_RIS = "1";
    public static final String VALID_FIRST_BUYER_PASIR_RIS = "4";
    public static final String VALID_SECOND_BUYER_PASIR_RIS = "6";
    public static final String NAME_DESC_PASIR_RIS = " " + PREFIX_NAME + VALID_NAME_PASIR_RIS;
    public static final String ADDRESS_DESC_PASIR_RIS = " " + PREFIX_ADDRESS + VALID_ADDRESS_PASIR_RIS;
    public static final String AREA_DESC_PASIR_RIS = " " + PREFIX_AREA + VALID_AREA_PASIR_RIS;
    public static final String PRICE_DESC_PASIR_RIS = " " + PREFIX_PRICE + VALID_PRICE_PASIR_RIS;
    public static final String REGION_DESC_PASIR_RIS = " " + PREFIX_REGION + VALID_REGION_PASIR_RIS;
    public static final String SELLER_DESC_PASIR_RIS = " " + PREFIX_SELLER + VALID_SELLER_PASIR_RIS;
    public static final String BUYER_DESC_PASIR_RIS = " " + PREFIX_BUYER + VALID_FIRST_BUYER_PASIR_RIS
            + " " + PREFIX_BUYER + VALID_SECOND_BUYER_PASIR_RIS;

    public static final EditClientCommand.EditPersonDescriptor DESC_AMY;
    public static final EditClientCommand.EditPersonDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult;
        if (command instanceof ShowClientsCommand) {
            expectedCommandResult = new CommandResult(expectedMessage, false,
                    false, false, true);
        } else if (command instanceof ShowListingsCommand) {
            expectedCommandResult = new CommandResult(expectedMessage, false,
                    false, true, false);
        } else {
            expectedCommandResult = new CommandResult(expectedMessage);
        }
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }
    /**
     * Updates {@code model}'s filtered list to show only the person with the given {@code targetName} in the
     * {@code model}'s address book.
     */
    public static void showPersonWithName(Model model, Name targetName) {
        Person person = model.getPersonByName(targetName);
        assertTrue(model.hasPerson(person));
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the listing at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showListingAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredListingList().size());

        Listing listing = model.getFilteredListingList().get(targetIndex.getZeroBased());
        final String[] splitName = listing.getName().fullName.split("\\s+");
        model.updateFilteredListingList(new ListingContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredListingList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the listing with the given {@code targetName} in the
     * {@code model}'s address book.
     */
    public static void showListingWithName(Model model, Name targetName) {
        Listing listing = model.getListingByName(targetName);
        assertTrue(model.hasListing(listing));
        final String[] splitName = listing.getName().fullName.split("\\s+");
        model.updateFilteredListingList(new ListingContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredListingList().size());
    }

}
