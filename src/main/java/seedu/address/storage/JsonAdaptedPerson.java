package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.Buyer;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Seller;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final JsonAdaptedAppointment appointment;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();
    private final String role;
    private final String remark;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                             @JsonProperty("email") String email,
                             @JsonProperty("appointment") JsonAdaptedAppointment appointment,
                             @JsonProperty("tags") List<JsonAdaptedTag> tags,
                             @JsonProperty("role") String role,
                             @JsonProperty("remark") String remark) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.appointment = appointment;
        this.role = role;
        if (tags != null) {
            this.tags.addAll(tags);
        }
        this.remark = remark;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        appointment = new JsonAdaptedAppointment(source.getAppointment());
        role = source instanceof Buyer ? "buyer" : "seller";
        tags.addAll(source.getTags().stream()
                  .map(JsonAdaptedTag::new)
                   .collect(Collectors.toList()));
        remark = source.getRemark();
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            personTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (appointment == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Appointment.class.getSimpleName()));
        }

        final Appointment modelAppointment = appointment.toModelType();

        final Set<Tag> modelTags = new HashSet<>(personTags);
        if (remark == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    "Remark"));
        }
        final String modelRemark = remark;
        if (role.equals("buyer")) {
            return new Buyer(modelName, modelPhone, modelEmail, modelTags, modelAppointment, remark);
        } else {
            return new Seller(modelName, modelPhone, modelEmail, modelTags, modelAppointment, remark);
        }
    }

}
