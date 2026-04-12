package image.manipulators.transformations.factory.registry;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import image.manipulators.transformations.ImageTransformer;
import image.manipulators.transformations.factory.TransformerFactory;
import util.ClassHelper;

import java.util.List;

public interface TransformerRegistry<T extends ImageTransformer<? extends InMemoryImage>> {
    default void registerAll(TransformerFactory<T> factory, String packageName) {
        Class<T> clazz = factory.getClazz();

        List<Class<T>> transformerClasses = ClassHelper
                .getClassesImplementationsInPackage(packageName, clazz);

        for (Class<T> cl : transformerClasses) {
            T transformer = getTransformerInstance(cl);

            for (FormatType supportedFormat : transformer.getSupportedFormats()) {
                factory.register(supportedFormat, cl);
            }
        }
    }

    T getTransformerInstance(Class<T> clazz);
}
