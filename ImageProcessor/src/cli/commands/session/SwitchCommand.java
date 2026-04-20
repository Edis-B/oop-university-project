package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import exceptions.CommandException;
import image.actions.Action;
import logging.ConsoleLoggingProvider;
import session.ImageWrapper;
import session.SessionManager;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SwitchCommand extends Command {
    private final ConsoleLoggingProvider consoleLoggingProvider;

    public SwitchCommand(ConsoleLoggingProvider consoleLoggingProvider) {
        this.consoleLoggingProvider = consoleLoggingProvider;
    }

    @Override
    public String getName() {
        return "switch";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (tokens.length != 2) {
            throw new ApplicationException("The 'switch' command requires exactly 1 argument (the session name or ID).");
        }

        int sessionId = Integer.parseInt(tokens[1]);
        boolean result = sessionManager.switchToSession(sessionId);

        if (!result) {
            throw new ApplicationException("Error switching session!");
        }

        consoleLoggingProvider.sendMessageNewline(String.format("You switched to the session with ID: %d!", sessionId));

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
