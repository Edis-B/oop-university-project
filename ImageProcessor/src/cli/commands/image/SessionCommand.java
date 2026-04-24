package cli.commands.image;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.Action;
import logging.Logger;
import session.ImageWrapper;
import session.SessionManager;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SessionCommand extends Command {
    private final Logger logger;

    public SessionCommand(Logger logger) {
        this.logger = logger;
    }

    @Override
    public List<String> helpSnippets() {
        return List.of(
                "info"
        );
    }

    @Override
    public String getName() {
        return "session";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (tokens.length != 2) {
            throw new ApplicationException("Unsupported argument count!");
        }

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
