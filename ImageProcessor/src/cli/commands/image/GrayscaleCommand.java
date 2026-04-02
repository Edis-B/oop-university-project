package cli.commands.image;

import cli.commands.Command;
import image.actions.GrayscaleAction;
import session.SessionManager;

public class GrayscaleCommand extends Command {
    @Override
    public String getName() {
        return "grayscale";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        sessionManager.addCommandToSession(new GrayscaleAction(sessionManager.getCurrentSessionImageCount()));
    }
}
