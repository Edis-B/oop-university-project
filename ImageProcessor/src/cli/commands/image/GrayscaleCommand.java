package cli.commands.image;

import cli.commands.Command;
import image.actions.GrayscaleAction;
import image.transformations.grayscaling.factory.GrayscalerFactory;
import session.SessionManager;

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
        sessionManager.addCommandToSession(
                new GrayscaleAction(sessionManager.getCurrentSessionImageCount(),
                        grayscalerFactory)
        );
    }
}
