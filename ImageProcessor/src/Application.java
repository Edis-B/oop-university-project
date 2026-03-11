import cli.CommandLineInterface;
import cli.CommandRegistry;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            CommandRegistry cmdRegistry = new CommandRegistry();
            cmdRegistry.discoverCommands();

            CommandLineInterface cli = new CommandLineInterface(cmdRegistry);

            Scanner sc = new Scanner(System.in);

            while (true) try {
                cli.start(sc);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}