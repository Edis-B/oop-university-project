package cli;

import cli.commands.Command;
import cli.commands.registry.AbstractCommandFactory;
import logging.Logger;
import session.SessionManager;

import java.util.Scanner;

public class CommandLineInterface {
    private final AbstractCommandFactory factory;
    private final Logger logger;

    public CommandLineInterface(AbstractCommandFactory registry, Logger logger) {
        this.factory = registry;
        this.logger = logger;
    }

    public void start(Scanner sc, SessionManager sessionManager) throws Exception {
        logger.sendMessage("> ");
        String input = sc.nextLine().trim();
        String[] tokens = input.split("\\s+");
        String commandName = tokens[0];

        Command cmd = factory.getCommand(commandName);
        if (cmd != null) {
            cmd.execute(tokens, sessionManager);
        } else {
            throw new IllegalArgumentException("Invalid command.");
        }
    }
}
