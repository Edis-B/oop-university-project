package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.AddAction;
import image.parsers.factories.FormatExtractor;
import image.parsers.factories.ParserFactory;
import session.SessionManager;

public class LoadCommand extends Command {
    private final FormatExtractor formatExtractor;
    private final ParserFactory parserFactory;

    private LoadCommand() {
        formatExtractor = null;
        parserFactory = null;
    }

    public LoadCommand(FormatExtractor _extractor, ParserFactory _parserFactory) {
        parserFactory = _parserFactory;
        formatExtractor = _extractor;
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getSession() != null)
            throw new ApplicationException("Already in session!");

        if (tokens.length != 2)
            throw new ApplicationException("Unsupported argument count!");

        sessionManager.startSession();
        sessionManager.addCommandToSession(new AddAction(tokens[1], formatExtractor, parserFactory));
    }
}
