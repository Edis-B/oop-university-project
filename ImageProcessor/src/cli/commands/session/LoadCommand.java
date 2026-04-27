package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.service.ImageLoaderService;
import logging.Logger;
import session.SessionManager;

import java.io.IOException;
import java.util.List;

public class LoadCommand extends Command {
    private final ImageLoaderService imageLoaderService;
    private final Logger logger;

    @Override
    public List<String> helpSnippets() {
        return List.of(
                "<image>",
                "<image1>, <image2>, ..."
        );
    }

    @Override
    public String getName() {
        return "load";
    }

    public LoadCommand(ImageLoaderService imageLoaderService, Logger logger) {
        this.imageLoaderService = imageLoaderService;
        this.logger = logger;
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (tokens.length == 1) {
            throw new ApplicationException("Please enter at least 1 image!");
        }

        logger.sendMessageNewline(
                String.format(
                        "Session with ID: %d started", sessionManager.newSession()
                )
        );

        for (int i = 1; i < tokens.length; i++) {
            try {
                String filePath = tokens[i];
                InMemoryImage newImage = imageLoaderService.load(filePath);
                sessionManager.insertImageIntoSession(
                        newImage, filePath
                );

                String newImageName = sessionManager.getCurrentImageContext().getImageWrapperArray().getLast().getName();

                logger.sendMessageNewline(
                        "Image \"" + newImageName + "\" added"
                );
            } catch (IOException e) {
                throw new ApplicationException("Count not load image: " + tokens[i], e);
            }
        }
    }
}
