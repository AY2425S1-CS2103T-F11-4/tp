package seedu.address.logic.parser.listingcommandparsers;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BUYER;

import java.util.HashSet;
import java.util.Set;

import seedu.address.logic.commands.listingcommands.AddBuyersToListingCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;

/**
 * Parses input arguments and creates a new AddBuyersToListingCommand object.
 */
public class AddBuyersToListingCommandParser implements Parser<AddBuyersToListingCommand> {

    @Override
    public AddBuyersToListingCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_BUYER);

        // Parse listing name
        String name = argMultimap.getPreamble();
        if (name.isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddBuyersToListingCommand.MESSAGE_USAGE));
        }
        Name listingName = ParserUtil.parseName(name);

        // Parse buyer names with the "buyer/" prefix
        Set<Name> buyerNames = new HashSet<>();
        for (String buyerNameStr : argMultimap.getAllValues(PREFIX_BUYER)) {
            buyerNames.add(ParserUtil.parseName(buyerNameStr));
        }

        // Check if there are buyer names; otherwise, throw an error
        if (buyerNames.isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddBuyersToListingCommand.MESSAGE_USAGE));
        }

        return new AddBuyersToListingCommand(listingName, buyerNames);
    }
}