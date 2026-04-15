package cli.commands.image;

import cli.commands.Command;
import common.constants.ErrorMessages;
import exceptions.ApplicationException;
import image.actions.collage.CollageAction;
import image.actions.collage.CollageDirection;
import image.manipulators.compositors.factory.CollagerFactory;
import session.SessionManager;

public class CollageCommand extends Command {
    private final CollagerFactory collagerFactory;

    public CollageCommand(CollagerFactory collagerFactory) {
        this.collagerFactory = collagerFactory;
    }

    @Override
    public String getName() {
        return "collage";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot apply transformation - not in session!");

        if (tokens.length != 5)
            throw new ApplicationException(ErrorMessages.unsupportedArgumentCount);

        CollageDirection collageDirection = CollageDirection.get(tokens[1]);

        if (collageDirection == null)
            throw new ApplicationException("Improper collage direction");

        sessionManager.addCommandToSession(
                new CollageAction(
                        collageDirection,
                        tokens[2],
                        tokens[3],
                        tokens[4]
                ,collagerFactory
                )
        );
    }
}
