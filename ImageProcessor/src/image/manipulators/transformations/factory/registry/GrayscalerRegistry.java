package image.manipulators.transformations.factory.registry;

import exceptions.ApplicationException;
import image.manipulators.transformations.grayscale.Grayscaler;
import image.images_in_memory.InMemoryImage;

public class GrayscalerRegistry implements TransformerRegistry<Grayscaler<InMemoryImage>> {
    @Override
    public Grayscaler<InMemoryImage> getTransformerInstance(Class<Grayscaler<InMemoryImage>> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate Grayscaler!", e);
        }
    }
}
