package image.actions;

public abstract class AbstractAction implements Action {
    private final String commandString;

    public AbstractAction(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }
}
