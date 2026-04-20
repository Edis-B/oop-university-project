package cli.commands.session;

import cli.commands.Command;
import image.service.ImageSerializerService;
import session.SessionManager;

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
        var transformedImages = sessionManager.executeCurrentSessionActions();

        for (var imageWrapper : transformedImages.getImageWrapperArray())
            imageSerializerService.serialize(imageWrapper);
    }
}
