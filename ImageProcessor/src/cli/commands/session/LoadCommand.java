package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.LoadAction;
import session.Session;
import session.SessionManager;

public class LoadCommand extends Command {
    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager != null)
            throw new ApplicationException("Already in session!");

        if (tokens.length != 2)
            throw new ApplicationException("Unsupported argument count!");

        Session newSession = new Session();
        sessionManager = new SessionManager(newSession);

        sessionManager.addCommandToSession(new LoadAction(tokens[1]));
    }
}
