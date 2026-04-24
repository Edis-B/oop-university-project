package cli.commands.session;

import cli.commands.Command;
import image.service.ImageSerializerService;
import session.ImageContext;
import session.ImageWrapper;
import session.SessionManager;

import java.util.List;

public class SaveCommand extends Command {
    private final ImageSerializerService imageSerializerService;

    public SaveCommand(ImageSerializerService imageSerializerService) {
        this.imageSerializerService = imageSerializerService;
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
            imageContext = sessionManager.executeCurrentSessionActionsOnAllImages();
        } else {
            imageContext = sessionManager.executeCurrentSessionActionsOnTheFirstImage();
        }

        for (var imageWrapper : imageContext.getImageWrapperArray()) {
            imageSerializerService.serialize(imageWrapper);
        }
    }
}
