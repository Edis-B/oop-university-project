package cli.commands.image;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.AddAction;
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
        if (sessionManager.getSession() == null)
            throw new ApplicationException("Cannot add image - not in session!");

        if (tokens.length != 2)
            throw new ApplicationException("Unsupported argument count!");

        String filePath = tokens[1];
        var newImage = imageLoaderService.load(tokens[1]);
        sessionManager.getSession().addFirst(new ImageWrapper(
                newImage, filePath
        ));

        sessionManager.addCommandToSession(new AddAction());
    }
}
