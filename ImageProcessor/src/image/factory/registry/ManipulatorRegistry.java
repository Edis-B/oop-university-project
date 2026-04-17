package image.factory.registry;

import image.factory.ManipulatorFactory;
import image.images_in_memory.InMemoryImage;
import image.manipulators.ImageManipulator;
import image.manipulators.annotation.AnnotationHelper;
import image.signatures.FormatType;
import util.ClassHelper;

import java.util.List;

public interface ManipulatorRegistry<T extends ImageManipulator<? extends InMemoryImage>> extends ClassRegistry<T, FormatType> {
    @Override
    default List<FormatType> getFactoryKey(Class<T> clazz) {
        return AnnotationHelper.getSupportedFormatTypes(clazz);
    }
}
