package cli.commands.image;

import cli.commands.Command;
import exceptions.ApplicationException;
import session.SessionManager;

public class CollageCommand extends Command {
    @Override
    public String getName() {
        return "collage";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot apply transformation - not in session!");
    }
}
