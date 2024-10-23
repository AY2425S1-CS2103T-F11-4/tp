package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import javafx.scene.input.KeyCode;
import seedu.address.Main;
import seedu.address.MainApp;
import seedu.address.commons.core.LogsCenter;

class MainUiTest extends ApplicationTest {

    private MainApp app;
    private Logger logger = LogsCenter.getLogger(Main.class);

    @Test
    void main_giveWarning_success() {
        try {
            Main.main(new String[]{});
            StringBuilder logOutput = new StringBuilder();
            Logger logger = Logger.getLogger(Main.class.getName());
            logger.addHandler(new java.util.logging.ConsoleHandler() {
                @Override
                public void publish(java.util.logging.LogRecord record) {
                    logOutput.append(record.getMessage()).append("\n");
                }
            });
            assertEquals(logOutput.toString(),
                    "The warning about Unsupported JavaFX configuration below (if any) can be ignored.");
        } catch (IllegalStateException e) {
            //do nothing
        }
    }

    @Test
    void main_opensApplication_success() throws TimeoutException {
        FxToolkit.registerPrimaryStage();

        try {
            Main.main(new String[]{});
        } catch (IllegalStateException e) {
            logger.warning("Caught IllegalStateException: " + e.getMessage());
        }

        app = new MainApp();
        FxToolkit.setupApplication(() -> app);

        FxToolkit.showStage();

        WaitForAsyncUtils.waitForFxEvents(20);

        FxRobot robot = new FxRobot();
        assertTrue(robot.lookup("#menuBar").tryQuery().isPresent(),
                "Main method opens application successfully");

        clickOn("#commandBoxPlaceholder");
        write("exit");
        push(KeyCode.ENTER);
    }
}
