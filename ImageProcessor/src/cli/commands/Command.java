package cli.commands;

public abstract class Command {
    public Command() {}

    public abstract void execute(String[] tokens);
}
