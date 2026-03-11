package cli;

import cli.commands.Command;
import session.SessionManager;

import java.util.Scanner;

public class CommandLineInterface {
    private final CommandRegistry registry;

    public CommandLineInterface(CommandRegistry registry) {
        this.registry = registry;
    }

    public void start(Scanner sc, SessionManager sessionManager) throws Exception {
        var input = sc.nextLine().trim();
        String[] tokens = input.split("\\s+");
        String commandName = tokens[0];

        Command cmd = registry.getCommand(commandName);
        if (cmd != null) {
            cmd.execute(tokens, sessionManager);
        } else {
            throw new IllegalArgumentException("Invalid command.");
        }
    }
}
