package image.manipulators.transformations.factory.registry;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.manipulators.transformations.rotate.Rotator;

public class RotatorRegistry implements TransformerRegistry<Rotator<InMemoryImage>> {
    @Override
    public Rotator<InMemoryImage> getTransformerInstance(Class<Rotator<InMemoryImage>> clazz) {
        try {
            return clazz.getConstructor(byte.class).newInstance((byte) 1);
        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate Rotator", e);
        }
    }
}
