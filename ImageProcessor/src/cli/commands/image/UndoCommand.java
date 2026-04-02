package cli.commands.image;

import cli.commands.Command;
import session.SessionManager;

public class UndoCommand extends Command {
    @Override
    public String getName() {
        return "undo";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        sessionManager.getCurrentSession().undoAction();
    }
}
