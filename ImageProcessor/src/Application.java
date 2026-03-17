import cli.CommandLineInterface;
import cli.CommandRegistryEnum;
import session.SessionManager;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            CommandRegistryEnum cmdRegistry = new CommandRegistryEnum();
            cmdRegistry.discoverCommands();

            CommandLineInterface cli = new CommandLineInterface(cmdRegistry);

            Scanner sc = new Scanner(System.in);
            SessionManager sessionManager = new SessionManager();

            while (true) try {
                cli.start(sc, sessionManager);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}