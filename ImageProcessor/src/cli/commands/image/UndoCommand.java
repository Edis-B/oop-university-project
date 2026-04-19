package cli.commands.image;

import cli.commands.Command;
import exceptions.ApplicationException;
import session.SessionManager;

public class UndoCommand extends Command {
    @Override
    public String getName() {
        return "undo";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot apply transformation - not in session!");

        if (sessionManager.getCurrentTransformationsCount() == 0)
            throw new ApplicationException("No transformations to undo!");

        sessionManager.getCurrentSession().undoAction();
    }
}
