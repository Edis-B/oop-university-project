package cli.commands.session;

import cli.commands.Command;
import logging.Logger;
import session.SessionManager;

import java.util.List;

public class HelpCommand extends Command {
    private final Logger logger;
    private final List<Command> commandListObjects;

    public HelpCommand(Logger logger, List<Command> commandListObjects) {
        this.logger = logger;
        this.commandListObjects = commandListObjects;
    }

    @Override
    public List<String> helpSnippets() {
        return List.of(
                ""
        );
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        for (Command c : commandListObjects) {
            for (var f : c.helpSnippets()) {
                logger.sendMessageNewline(String.format("> %s %s", c.getName(), f));
            }
        }
    }
}
