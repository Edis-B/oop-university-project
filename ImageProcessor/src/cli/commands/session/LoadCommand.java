package cli.commands.session;

import cli.commands.Command;
import exceptions.ApplicationException;
import image.actions.AddAction;
import image.service.ImageLoaderService;
import session.ImageWrapper;
import session.SessionManager;

public class LoadCommand extends Command {
    private final ImageLoaderService imageLoaderService;

    private LoadCommand() {
        this(null);
    }

    @Override
    public String getName() {
        return "load";
    }

    public LoadCommand(ImageLoaderService _imageLoaderService) {
        imageLoaderService = _imageLoaderService;
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getSession() != null)
            throw new ApplicationException("Already in session!");

        if (tokens.length != 2)
            throw new ApplicationException("Unsupported argument count!");

        sessionManager.startSession();

        String filePath = tokens[1];
        var newImage = imageLoaderService.load(tokens[1]);
        sessionManager.getSession().addFirst(new ImageWrapper(
                newImage, filePath
        ));

        sessionManager.addCommandToSession(new AddAction());
    }
}
