package cli.commands.session;

import cli.commands.Command;
import session.SessionManager;

public class CloseCommand extends Command {
    @Override
    public String getName() {
        return "close";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {

    }
}
