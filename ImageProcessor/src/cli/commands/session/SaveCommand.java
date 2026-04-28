package cli.commands.session;

import cli.commands.Command;
import image.service.ImageSerializerService;
import logging.Logger;
import session.ImageContext;
import session.SessionManager;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class SaveCommand extends Command {
    private final ImageSerializerService imageSerializerService;
    private final Logger logger;

    public SaveCommand(Logger logger, ImageSerializerService imageSerializerService) {
        this.imageSerializerService = imageSerializerService;
        this.logger = logger;
    }

    @Override
    public List<String> helpSnippets() {
        return List.of(
                "",
                "as"
        );
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        ImageContext imageContext;
        if (tokens.length >= 2 && tokens[1].equalsIgnoreCase("as")) {
            imageContext = sessionManager.executeActionsOnTheFirstImage();
        } else {
            imageContext = sessionManager.executeActionsOnAllImages();
        }

        int ctr = 0;
        for (var imageWrapper : imageContext.getImageWrapperArray()) {
            imageSerializerService.serialize(imageWrapper);
            ctr++;
        }

        if (ctr > 0) {
            File file = new File("result_images");
            String filePath = file.getAbsolutePath();
            logger.sendMessageNewline(String.format("Successfully serialized %d images to %s!", ctr, filePath));

        } else
            logger.sendErrorNewline("No images serialized!");
    }
}
