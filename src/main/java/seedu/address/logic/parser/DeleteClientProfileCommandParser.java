package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.DeleteClientProfileCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;

/**
 * Parses input arguments and creates a new DeleteClientProfileCommand object
 */
public class DeleteClientProfileCommandParser implements Parser<DeleteClientProfileCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteClientProfileCommand
     * and returns a DeleteClientProfileCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteClientProfileCommand parse(String args) throws ParseException {

        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args);

        try {
            // Parse the name and return the DeleteClientProfileCommand
            Name name = ParserUtil.parseName(argumentMultimap.getPreamble());
            return new DeleteClientProfileCommand(name);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeleteClientProfileCommand.MESSAGE_USAGE), pe);
        }
    }

}
