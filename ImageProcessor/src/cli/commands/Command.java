package cli.commands;

import session.SessionManager;

public abstract class Command {
    public Command() {}

    public abstract void execute(String[] tokens, SessionManager sessionManager) throws Exception;
}
