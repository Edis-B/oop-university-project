package cli.commands;

import session.SessionManager;

public abstract class Command {
    public Command() {}

    public abstract String getName();

    public abstract void execute(String[] tokens, SessionManager sessionManager) throws Exception;
}
