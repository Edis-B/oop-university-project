package image.service;

import common.constants.RandomConstants;
import image.images_in_memory.InMemoryImage;
import image.io.serializers.ImageSerializer;
import image.io.serializers.factory.SerializerFactory;
import session.ImageWrapper;

import java.io.*;

public class ImageSerializerService {
    private final SerializerFactory serializerFactory;

    public ImageSerializerService(SerializerFactory serializerFactory) {
        this.serializerFactory = serializerFactory;
    }

    public void serialize(ImageWrapper wrapper) {
        try {
            InMemoryImage image = wrapper.getImage();
            File outDirectory = new File(RandomConstants.outputDirectoryName);

            String fileName = wrapper.getName();
            File outFile = new File(outDirectory, fileName);

            OutputStream os = new FileOutputStream(outFile);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            Class<ImageSerializer<? extends InMemoryImage>> serializerClass = serializerFactory.search(image.getFormat());

            ImageSerializer<? extends InMemoryImage> serializer = serializerClass.newInstance();

            serializeSafely(bos, serializer, image);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T extends InMemoryImage> void serializeSafely(BufferedOutputStream bos,
                                                           ImageSerializer<T> serializer,
                                                           InMemoryImage image) {
        @SuppressWarnings("unchecked")
        T parsedImage = (T) image;

        serializer.serialize(bos, parsedImage);
    }
}
