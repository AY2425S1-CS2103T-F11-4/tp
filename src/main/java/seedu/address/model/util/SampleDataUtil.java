package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static final Remark EMPTY_REMARK = new Remark("");
    public static final Property EMPTY_PROPERTY = new Property("");

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), EMPTY_PROPERTY),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), EMPTY_PROPERTY),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), EMPTY_PROPERTY),
            new Person(new Name("David Li"), new Phone("91031282"), EMPTY_PROPERTY),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), EMPTY_PROPERTY),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), EMPTY_PROPERTY)
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
