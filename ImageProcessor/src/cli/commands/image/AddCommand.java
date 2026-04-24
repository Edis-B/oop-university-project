package cli.commands.image;

import cli.commands.Command;
import common.constants.ErrorMessages;
import exceptions.ApplicationException;
import image.service.ImageLoaderService;
import logging.Logger;
import session.SessionManager;

import java.util.List;

public class AddCommand extends Command {
    private final Logger logger;
    private final ImageLoaderService imageLoaderService;

    public AddCommand(ImageLoaderService imageLoaderService, Logger logger) {
        this.imageLoaderService = imageLoaderService;
        this.logger = logger;
    }

    @Override
    public List<String> helpSnippets() {
        return List.of(
                "<image>"
        );
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

            logger.sendMessageNewline("Image \"" + newImageName + "\" added");
        } catch (Exception e) {
            throw new ApplicationException(String.format("Error loading image (%s): ", tokens[1]) + e.getMessage());
        }
    }
}
