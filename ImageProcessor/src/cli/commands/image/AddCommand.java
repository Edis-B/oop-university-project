package cli.commands.image;

import cli.commands.Command;
import common.constants.ErrorMessages;
import exceptions.ApplicationException;
import image.service.ImageLoaderService;
import session.ImageWrapper;
import session.SessionManager;

public class AddCommand extends Command {
    private final ImageLoaderService imageLoaderService;

    private AddCommand() {
        this(null);
    }

    public AddCommand(ImageLoaderService _imageLoaderService) {
        imageLoaderService = _imageLoaderService;
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

        String filePath = tokens[1];
        var newImage = imageLoaderService.load(tokens[1]);
        sessionManager.insertImageIntoSession(
            newImage, filePath
        );
    }
}
