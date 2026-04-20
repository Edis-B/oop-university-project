package cli.commands.image;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.MonochromeAction;
import image.manipulators.transformations.factory.MonochromerFactory;
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
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot apply transformation - not in session!");

        String command = String.join(" ", tokens);

        sessionManager.addCommandToSession(
                new MonochromeAction(
                        sessionManager.getCurrentSessionImageCount(),
                        monochromerFactory,
                        command)
        );
    }
}
