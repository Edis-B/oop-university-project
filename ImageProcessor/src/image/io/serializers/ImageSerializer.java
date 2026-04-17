package image.io.serializers;

import image.images_in_memory.InMemoryImage;

import java.io.BufferedOutputStream;

public interface ImageSerializer<T extends InMemoryImage> {
    void serialize(BufferedOutputStream bos);
}
