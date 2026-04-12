package image.manipulators.transformations.factory.registry;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.manipulators.transformations.monochrome.Monochromer;

public class MonochromerRegistry implements TransformerRegistry<Monochromer<InMemoryImage>> {
    @Override
    public Monochromer<InMemoryImage> getTransformerInstance(Class<Monochromer<InMemoryImage>> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate Monochromer", e);
        }
    }
}
