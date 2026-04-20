package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.service.ImageLoaderService;
import logging.ConsoleLoggingProvider;
import session.SessionManager;

import java.io.IOException;

public class LoadCommand extends Command {
    private final ImageLoaderService imageLoaderService;
    private final ConsoleLoggingProvider consoleLoggingProvider;

    private LoadCommand() {
        this(null, null);
    }

    @Override
    public String getName() {
        return "load";
    }

    public LoadCommand(ImageLoaderService imageLoaderService, ConsoleLoggingProvider consoleLoggingProvider) {
        this.imageLoaderService = imageLoaderService;
        this.consoleLoggingProvider = consoleLoggingProvider;
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (tokens.length == 1)
            throw new ApplicationException("Please enter at least 1 image!");

        consoleLoggingProvider.sendMessageNewline(
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
                consoleLoggingProvider.sendMessageNewline(
                        "Image \"" + newImageName + "\" added"
                );
            } catch (IOException e) {
                throw new ApplicationException("Count not load image: " + tokens[i], e);
            }
        }
    }
}
