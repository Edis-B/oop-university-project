package image.transformations.registry;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import image.transformations.ImageTransformer;
import image.transformations.factory.TransformerFactory;
import util.ClassHelper;

import java.util.List;

public interface TransformerRegistry<T extends ImageTransformer<? extends InMemoryImage>> {
    default void registerAll(TransformerFactory<T> factory, String packageName) {
        Class<T> clazz = factory.getTransformerType();

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
