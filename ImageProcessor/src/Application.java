import cli.CommandLineInterface;
import cli.CommandRegistryEnum;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            CommandRegistryEnum cmdRegistry = new CommandRegistryEnum();
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