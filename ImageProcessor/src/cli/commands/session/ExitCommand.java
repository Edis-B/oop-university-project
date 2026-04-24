package cli.commands.session;

import cli.commands.Command;
import logging.Logger;
import session.SessionManager;

import java.util.List;

public class ExitCommand extends Command {
    private final Logger logger;

    public ExitCommand(Logger logger) {
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
        return "exit";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        logger.sendMessage("Closing program...");
        System.exit(0);
    }
}
