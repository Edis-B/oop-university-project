package cli.commands.image;

import cli.commands.Command;
import image.actions.Action;
import logging.ConsoleLoggingProvider;
import session.ImageWrapper;
import session.SessionManager;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SessionCommand extends Command {
    private final ConsoleLoggingProvider consoleLoggingProvider;

    public SessionCommand(ConsoleLoggingProvider consoleLoggingProvider) {
        this.consoleLoggingProvider = consoleLoggingProvider;
    }

    @Override
    public String getName() {
        return "session";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (tokens.length != 2) {

        }

        List<ImageWrapper> images = sessionManager.getCurrentImageContext().getImageWrapperArray();
        if (!images.isEmpty()) {
            consoleLoggingProvider.sendMessage("Name of images in the session: ");

            consoleLoggingProvider.sendMessageNewline(
                    images.stream()
                            .map(ImageWrapper::getName)
                            .collect(Collectors.joining(" "))
            );
        } else {
            consoleLoggingProvider.sendMessageNewline("No images in session!");
        }

        Stack<Action> transformations = sessionManager.getCurrentSession().getCommandHistory();
        if (!transformations.isEmpty()) {
            consoleLoggingProvider.sendMessage("Pending transformations: ");

            consoleLoggingProvider.sendMessageNewline(
                    transformations.stream()
                            .map(Action::getCommandString)
                            .collect(Collectors.joining(", "))
            );
        } else {
            consoleLoggingProvider.sendMessageNewline("No transformations pending!");
        }
    }
}
