package image.io.serializers.factory;

import image.factory.AbstractFactory;
import image.images_in_memory.InMemoryImage;
import image.io.serializers.ImageSerializer;
import image.signatures.FormatType;

public class SerializerFactory extends AbstractFactory<ImageSerializer<? extends InMemoryImage>, FormatType> {
    @Override
    public Class<ImageSerializer<? extends InMemoryImage>> getClazz() {
        //noinspection unchecked
        return (Class<ImageSerializer<? extends InMemoryImage>>) (Class<?>) ImageSerializer.class;
    }
}
