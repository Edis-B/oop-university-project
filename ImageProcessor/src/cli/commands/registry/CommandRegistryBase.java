package cli.commands.registry;

import cli.commands.Command;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandRegistryBase {
    protected final Map<String, Command> commands = new HashMap<>();

    public abstract void discoverCommands() throws Exception;

    public Command getCommand(String name) {
        return commands.get(name.toLowerCase());
    }
}
