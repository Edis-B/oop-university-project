package cli.commands.session;

import cli.commands.Command;
import logging.Logger;
import session.SessionManager;

import java.util.List;

public class CloseCommand extends Command {
    private final Logger logger;

    public CloseCommand(Logger logger) {
        this.logger = logger;
    }

    @Override
    public List<String> helpSnippets() {
        return List.of(
                ""
        );
    }

    @Override
    public String getName() {
        return "close";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        sessionManager.switchToSession(0);
        logger.sendMessageNewline("Successfully closed session!");
    }
}
