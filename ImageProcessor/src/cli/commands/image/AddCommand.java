package cli.commands.image;

import cli.commands.Command;
import common.constants.ErrorMessages;
import exceptions.ApplicationException;
import image.service.ImageLoaderService;
import logging.ConsoleLoggingProvider;
import session.ImageWrapper;
import session.SessionManager;

import java.io.IOException;

public class AddCommand extends Command {
    private final ConsoleLoggingProvider consoleLoggingProvider;
    private final ImageLoaderService imageLoaderService;

    public AddCommand(ImageLoaderService imageLoaderService, ConsoleLoggingProvider consoleLoggingProvider) {
        this.imageLoaderService = imageLoaderService;
        this.consoleLoggingProvider = consoleLoggingProvider;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot add image - not in session!");

        if (tokens.length != 2)
            throw new ApplicationException(ErrorMessages.unsupportedArgumentCount);

        try {
            String filePath = tokens[1];
            var newImage = imageLoaderService.load(tokens[1]);
            sessionManager.insertImageIntoSession(
                    newImage, filePath
            );

            var newImageName = sessionManager.getCurrentImageContext().getImageWrapperArray().getLast().getName();

            consoleLoggingProvider.sendMessageNewline("Image \"" + newImageName + "\" added");
        } catch (Exception e) {
            throw new ApplicationException(String.format("Error loading image (%s): ", tokens[1]) + e.getMessage());
        }
    }
}
