package cli.commands.image;

import cli.commands.Command;
import image.actions.NegativeAction;
import image.transformations.factory.negating.NegatorFactory;
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
        sessionManager.addCommandToSession(
                new NegativeAction(sessionManager.getCurrentSessionImageCount(),
                        negatorFactory)
        );
    }
}
