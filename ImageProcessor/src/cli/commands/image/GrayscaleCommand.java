package cli.commands.image;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.GrayscaleAction;
import image.manipulators.transformations.factory.GrayscalerFactory;
import session.SessionManager;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GrayscaleCommand extends Command {
    private final GrayscalerFactory grayscalerFactory;

    public GrayscaleCommand(GrayscalerFactory grayscalerFactory) {
        this.grayscalerFactory = grayscalerFactory;
    }

    @Override
    public String getName() {
        return "grayscale";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot apply transformation - not in session!");

        String command = String.join(" ", tokens);

        sessionManager.addCommandToSession(
                new GrayscaleAction(sessionManager.getCurrentSessionImageCount(),
                        grayscalerFactory,
                        command)
        );
    }
}
