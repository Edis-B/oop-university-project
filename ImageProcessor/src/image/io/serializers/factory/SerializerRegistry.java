package image.io.serializers.factory;

import image.factory.registry.ClassRegistry;
import image.images_in_memory.InMemoryImage;
import image.io.serializers.ImageSerializer;
import image.manipulators.annotation.AnnotationHelper;
import image.manipulators.transformations.factory.registry.GrayscalerRegistry;
import image.signatures.FormatType;

import java.util.List;

public class SerializerRegistry implements ClassRegistry<ImageSerializer<? extends InMemoryImage>, FormatType> {
    @Override
    public List<FormatType> getFactoryKey(Class<ImageSerializer<? extends InMemoryImage>> clazz) {
        return AnnotationHelper.getSupportedFormatTypes(clazz);
    }
}
