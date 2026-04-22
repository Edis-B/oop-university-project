package cli.commands.session;

import cli.commands.Command;
import image.service.ImageSerializerService;
import session.ImageContext;
import session.ImageWrapper;
import session.SessionManager;

import java.util.List;
import java.util.Objects;

public class SaveCommand extends Command {
    private final ImageSerializerService imageSerializerService;

    public SaveCommand(ImageSerializerService imageSerializerService) {
        this.imageSerializerService = imageSerializerService;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public void execute(String[] tokens, SessionManager sessionManager) {
        ImageContext transformedImages = sessionManager.executeCurrentSessionActions();
        List<ImageWrapper> wrappers = transformedImages.getImageWrapperArray();

        int n = wrappers.size();
        if (tokens.length >= 2 && tokens[1].equalsIgnoreCase("as")) {
            n = 1;
        }

        for (int i = 0; i < n; i++) {
            imageSerializerService.serialize(wrappers.get(i));
        }
    }
}
