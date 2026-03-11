package cli;

import cli.commands.Command;
import java.util.*;

public class CommandRegistryEnum extends CommandRegistry {
    @Override
    public void discoverCommands() throws Exception {
        for (CommandTypes type : CommandTypes.values()) {
            try {
                Object instance = type.getCommandClass()
                        .getDeclaredConstructor()
                        .newInstance();

                if (instance instanceof Command)
                    commands.put(type.getCommandString().toLowerCase(), (Command) instance);

            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
    }
}