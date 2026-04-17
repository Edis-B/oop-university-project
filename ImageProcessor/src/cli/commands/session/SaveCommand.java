package cli.commands.session;

import cli.commands.Command;
import image.images_in_memory.InMemoryImage;
import image.io.serializers.ImageSerializer;
import image.io.serializers.factory.SerializerFactory;
import image.io.serializers.factory.SerializerRegistry;
import image.service.ImageSerializerService;
import session.ImageWrapper;
import session.SessionManager;

import java.io.*;

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
        var transformedImages = sessionManager.executeActions();

        for (var imageWrapper : transformedImages.getImageWrapperArray())
            imageSerializerService.serialize(imageWrapper);
    }
}
