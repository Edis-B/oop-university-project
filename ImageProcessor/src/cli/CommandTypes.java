package cli;

import cli.commands.image.*;

public enum CommandTypes {
    //
    GRAYSCALE("grayscale", GrayscaleCommand.class),
    MONOCHROME("monochrome", MonochromeCommand.class),
    NEGATIVE("negative", NegativeCommand.class),
    ROTATE("rotate", RotateCommand.class),
    UNDO("undo", UndoCommand.class),
    ADD("add", AddCommand.class),
    SESSION("session", SessionCommand.class),
    SWITCH("switch", SwitchCommand.class),
    COLLAGE("collage", CollageCommand.class);

    private final String commandString;
    private final Class<?> commandClass;

    CommandTypes(String commandString, Class<?> commandClass) {
        this.commandString = commandString;
        this.commandClass = commandClass;
    }

    public String getCommandString() {
        return commandString;
    }

    public Class<?> getCommandClass() {
        return commandClass;
    }
}
