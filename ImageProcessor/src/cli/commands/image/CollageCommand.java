package cli.commands.image;

import cli.commands.Command;
import common.constants.ErrorMessages;
import exceptions.ApplicationException;
import image.actions.collage.CollageAction;
import image.actions.collage.CollageDirection;
import image.manipulators.compositors.factory.CollagerFactory;
import logging.Logger;
import session.SessionManager;

import java.util.List;

public class CollageCommand extends Command {
    private final CollagerFactory collagerFactory;
    private final Logger logger;

    public CollageCommand(CollagerFactory collagerFactory, Logger logger) {
        this.collagerFactory = collagerFactory;
        this.logger = logger;
    }

    @Override
    public List<String> helpSnippets() {
        return List.of(
                "<direction> <image1> <image2> <outimage>"
        );
    }

    @Override
    public String getName() {
        return "collage";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        if (sessionManager.getCurrentSession() == null)
            throw new ApplicationException("Cannot apply transformation - not in session!");

        if (tokens.length != 5)
            throw new ApplicationException(ErrorMessages.unsupportedArgumentCount);

        CollageDirection collageDirection = CollageDirection.get(tokens[1]);

        if (collageDirection == null)
            throw new ApplicationException("Improper collage direction");

        String command = String.join(" ", tokens);

        new CollageAction(
                collageDirection,
                tokens[2],
                tokens[3],
                tokens[4],
                collagerFactory,
                command
        ).execute(sessionManager.getCurrentImageContext());

        String newImageName = sessionManager.getCurrentImageContext().getImageWrapperArray().getLast().getName();

        logger.sendMessageNewline("New collage " + newImageName + " created");
    }
}
