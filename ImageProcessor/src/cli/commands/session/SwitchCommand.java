package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.Action;
import logging.Logger;
import session.ImageWrapper;
import session.SessionManager;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SwitchCommand extends Command {
    private final Logger logger;

    public SwitchCommand(Logger logger) {
        this.logger = logger;
    }

    @Override
    public List<String> helpSnippets() {
        return List.of(
                "<sessionId>"
        );
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

        logger.sendMessageNewline(String.format("You switched to the session with ID: %d!", sessionId));

        List<ImageWrapper> images = sessionManager.getCurrentImageContext().getImageWrapperArray();
        if (!images.isEmpty()) {
            logger.sendMessage("Name of images in the session: ");

            logger.sendMessageNewline(
                    images.stream()
                            .map(ImageWrapper::getName)
                            .collect(Collectors.joining(" "))
            );
        } else {
            logger.sendMessageNewline("No images in session!");
        }

        Stack<Action> transformations = sessionManager.getCurrentSession().getCommandHistory();
        if (!transformations.isEmpty()) {
            logger.sendMessage("Pending transformations: ");

            logger.sendMessageNewline(
                    transformations.stream()
                            .map(Action::getCommandString)
                            .collect(Collectors.joining(", "))
            );
        } else {
            logger.sendMessageNewline("No transformations pending!");
        }
    }
}
