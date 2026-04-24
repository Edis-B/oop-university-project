package cli.commands.image;

import cli.commands.Command;
import exceptions.ApplicationException;
import logging.Logger;
import session.SessionManager;

import java.util.List;

public class UndoCommand extends Command {
    private final Logger logger;

    public UndoCommand(Logger logger) {
        this.logger = logger;
    }

    @Override
    public List<String> helpSnippets() {
        return List.of(
                ""
        );
    }

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

        var undone = sessionManager.getCurrentSession().undoAction();

        logger.sendMessageNewline("Transformation undone: " + undone.getCommandString());
    }
}
