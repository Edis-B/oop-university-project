package cli.commands.registry;

import cli.commands.Command;

import java.util.List;

public class CommandRegistry extends CommandRegistryBase {
    private final List<Command> commandList;

    public CommandRegistry(List<Command> _commandList) {
        commandList = _commandList;
    }

    @Override
    public void discoverCommands() throws Exception {
        for (Command cmd : commandList) {
            commands.put(cmd.getName(), cmd);
        }
    }
}
