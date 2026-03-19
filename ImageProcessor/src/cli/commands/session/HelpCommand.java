package cli.commands.session;

import cli.commands.Command;
import session.SessionManager;

public class HelpCommand extends Command {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {

    }
}
