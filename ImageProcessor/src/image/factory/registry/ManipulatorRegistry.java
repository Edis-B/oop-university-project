package image.factory.registry;

import image.factory.ManipulatorFactory;
import image.images_in_memory.InMemoryImage;
import image.manipulators.ImageManipulator;
import image.manipulators.annotation.AnnotationHelper;
import image.signatures.FormatType;
import util.ClassHelper;

import java.util.List;

public interface ManipulatorRegistry<T extends ImageManipulator<? extends InMemoryImage>> {
    default void registerAll(ManipulatorFactory<T> factory, String packageName) {
        Class<T> clazz = factory.getClazz();

        List<Class<T>> manipulatorClasses = ClassHelper
                .getClassesImplementationsInPackage(packageName, clazz);

        for (Class<T> cl : manipulatorClasses) {
            List<FormatType> supportedFormats = AnnotationHelper.getSupportedFormatTypes(cl);

            for (FormatType supportedFormat : supportedFormats) {
                factory.register(supportedFormat, cl);
            }
        }
    }
}
