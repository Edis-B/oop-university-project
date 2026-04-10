package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.service.ImageLoaderService;
import logging.ConsoleLoggingProvider;
import session.SessionManager;

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

    public LoadCommand(ImageLoaderService _imageLoaderService, ConsoleLoggingProvider _consoleLogginProvider) {
        imageLoaderService = _imageLoaderService;
        consoleLoggingProvider = _consoleLogginProvider;
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() != null)
            throw new ApplicationException("Already in session!");

        if (tokens.length == 1)
            throw new ApplicationException("Please enter at least 1 image!");

        consoleLoggingProvider.sendMessageNewline(
            String.format(
                "Session with ID: %d started", sessionManager.newSession()
            )
        );

        for (int i = 1; i < tokens.length; i++) {
            String filePath = tokens[i];
            InMemoryImage newImage = imageLoaderService.load(tokens[1]);
            sessionManager.insertImageIntoSession(
                newImage, filePath
            );
        }
    }
}
