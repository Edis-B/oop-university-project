package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.AddAction;
import session.SessionManager;

public class LoadCommand extends Command {
    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getSession() != null)
            throw new ApplicationException("Already in session!");

        if (tokens.length != 2)
            throw new ApplicationException("Unsupported argument count!");

        sessionManager.startSession();
        sessionManager.addCommandToSession(new AddAction(tokens[1]));
    }
}
