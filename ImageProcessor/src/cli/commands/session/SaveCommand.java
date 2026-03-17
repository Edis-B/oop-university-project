package cli.commands.session;

import cli.commands.Command;
import session.SessionManager;

public class SaveCommand extends Command {
    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        sessionManager.executeActions();
    }
}
