package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
//    private final Email email;
//
//    // Data fields
//    private final Address address;
//    private final Remark remark;
    private final Property property;
//    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Property property) {
        requireAllNonNull(name, phone, property);
        this.name = name;
        this.phone = phone;
//        this.email = email;
//        this.address = address;
//        this.remark = remark;
        this.property = property;
//        this.tags.addAll(tags);
    }

    public Person(Name name) {
        this.name = name;
        this.phone = null;
        this.property = new Property("");
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

//    public Email getEmail() {
//        return email;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public Remark getRemark() {
//        return remark;
//    }

    public Property getProperty() {
        return property;
    }

//    /**
//     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
//     * if modification is attempted.
//     */
//    public Set<Tag> getTags() {
//        return Collections.unmodifiableSet(tags);
//    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && property.equals(otherPerson.property);
//                && email.equals(otherPerson.email)
//                && address.equals(otherPerson.address)
//                && tags.equals(otherPerson.tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, property);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
//                .add("email", email)
//                .add("address", address)
//                .add("remark", remark)
//                .add("tags", tags)
                .add("property", property)
                .toString();
    }

}
