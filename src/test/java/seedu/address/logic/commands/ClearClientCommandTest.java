package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Listings;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;


public class ClearClientCommandTest {

    @Test
    public void execute_emptyClient_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearClientCommand(), model,
                ClearClientCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyClient_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new Listings());
        Model expectedModel = new ModelManager(new AddressBook(), new UserPrefs(), new Listings());

        assertCommandSuccess(new ClearClientCommand(), model,
                ClearClientCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
