package cli.commands.image;

import cli.commands.Command;
import image.actions.MonochromeAction;
import image.transformations.monochroming.factory.MonochromerFactory;
import session.SessionManager;

public class MonochromeCommand extends Command {
    private final MonochromerFactory monochromerFactory;

    public MonochromeCommand(MonochromerFactory monochromerFactory) {
        this.monochromerFactory = monochromerFactory;
    }

    @Override
    public String getName() {
        return "monochrome";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        sessionManager.addCommandToSession(
                new MonochromeAction(sessionManager.getCurrentSessionImageCount(), monochromerFactory)
        );
    }
}
