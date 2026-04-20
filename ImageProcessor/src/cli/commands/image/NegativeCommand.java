package cli.commands.image;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.NegativeAction;
import image.manipulators.transformations.factory.NegatorFactory;
import session.SessionManager;

public class NegativeCommand extends Command {
    private final NegatorFactory negatorFactory;

    public NegativeCommand(NegatorFactory negatorFactory) {
        this.negatorFactory = negatorFactory;
    }

    @Override
    public String getName() {
        return "negative";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot apply transformation - not in session!");

        String command = String.join(" ", tokens);

        sessionManager.addCommandToSession(
                new NegativeAction(sessionManager.getCurrentSessionImageCount(),
                        negatorFactory, command)
        );
    }
}
