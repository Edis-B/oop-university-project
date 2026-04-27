import cli.CommandLineInterface;
import cli.commands.Command;
import cli.commands.registry.CommandRegistry;
import cli.commands.registry.CommandFactory;
import logging.ConsoleLoggerProvider;
import logging.Logger;
import session.SessionManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        boolean isDebug = Arrays.asList(args).contains("debug");
        Logger logger = new ConsoleLoggerProvider();
        try {
            CommandRegistry commandRegistry = new CommandRegistry();
            List<Command> commandList = commandRegistry.createAllCommands();

            CommandFactory commandFactory = new CommandFactory(commandList);
            commandFactory.discoverCommands();

            CommandLineInterface cli = new CommandLineInterface(commandFactory, logger);

            Scanner sc = new Scanner(System.in);
            SessionManager sessionManager = new SessionManager();

            while (true) try {
                cli.start(sc, sessionManager);
            } catch (Exception e) {
                logger.sendErrorNewline(e.getMessage());
                if (isDebug)
                    e.printStackTrace();
            }
        } catch (Exception e) {
            logger.sendErrorNewline(e.getMessage());
            if (isDebug)
                e.printStackTrace();
        }
    }
}