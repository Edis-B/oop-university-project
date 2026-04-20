package cli.commands.image;

import cli.commands.Command;
import common.constants.ErrorMessages;
import exceptions.ApplicationException;
import image.actions.rotate.RotateAction;
import image.actions.rotate.RotateDirection;
import image.manipulators.transformations.factory.RotatorFactory;
import session.SessionManager;

public class RotateCommand extends Command {
    private final RotatorFactory rotatorFactory;

    public RotateCommand(RotatorFactory rotatorFactory) {
        this.rotatorFactory = rotatorFactory;
    }

    @Override
    public String getName() {
        return "rotate";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot apply transformation - not in session!");

        if (tokens.length != 2)
            throw new ApplicationException(ErrorMessages.unsupportedArgumentCount);

        String rotateDirectionString = tokens[1].replace('-', '_').toUpperCase();
        RotateDirection rotateDirection = RotateDirection.valueOf(rotateDirectionString);

        String command = String.join(" ", tokens);

        sessionManager.addCommandToSession(
                new RotateAction(sessionManager.getCurrentSessionImageCount(),
                        rotateDirection,
                        rotatorFactory,
                        command
                )
        );
    }
}
