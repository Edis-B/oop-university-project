import cli.CommandLineInterface;
import cli.commands.Command;
import cli.commands.registry.CommandRegistry;
import cli.commands.registry.CommandFactory;
import session.SessionManager;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            List<Command> commandList = (new CommandRegistry()).createAllCommands();
            CommandFactory cmdRegistry = new CommandFactory(commandList);
            cmdRegistry.discoverCommands();

            CommandLineInterface cli = new CommandLineInterface(cmdRegistry);

            Scanner sc = new Scanner(System.in);
            SessionManager sessionManager = new SessionManager();

            while (true) try {
                cli.start(sc, sessionManager);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}