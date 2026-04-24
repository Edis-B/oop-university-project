package cli.commands;

import session.SessionManager;

import java.util.List;

public abstract class Command {
    public Command() {}

    public abstract List<String> helpSnippets();

    public abstract String getName();

    public abstract void execute(String[] tokens, SessionManager sessionManager) throws Exception;
}
