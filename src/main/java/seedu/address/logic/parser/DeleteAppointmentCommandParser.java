package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MISSING_CLIENT_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.address.logic.commands.DeleteAppointmentCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;

/**
 * Parses input arguments and creates a new {@code DeleteAppointmentCommand} object.
 */
public class DeleteAppointmentCommandParser implements Parser<DeleteAppointmentCommand> {

    /**
     * Parses the given {@code String} of arguments and returns a {@code DeleteAppointmentCommand} object for execution.
     *
     * @param args User input containing the client's name prefixed with "n/".
     * @return A {@code DeleteAppointmentCommand} object.
     * @throws ParseException If the user input does not conform to the expected format or the name is missing.
     */
    public DeleteAppointmentCommand parse(String args) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args);

        try {
            // Parse the name and return the DeleteAppointmentCommand
            Name name = ParserUtil.parseName(argumentMultimap.getPreamble());
            return new DeleteAppointmentCommand(name);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeleteAppointmentCommand.MESSAGE_USAGE), pe);
        }
    }
}
