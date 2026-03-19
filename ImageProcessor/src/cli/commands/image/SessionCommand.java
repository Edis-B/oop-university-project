package cli.commands.image;

import cli.commands.Command;
import session.SessionManager;

public class SessionCommand extends Command {
    @Override
    public String getName() {
        return "session";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {

    }
}
