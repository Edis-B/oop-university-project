package image.transformations.registry;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;

import image.transformations.negative.Negator;

public class NegatorRegistry implements TransformerRegistry<Negator<InMemoryImage>> {
    @Override
    public Negator<InMemoryImage> getTransformerInstance(Class<Negator<InMemoryImage>> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate Negator", e);
        }
    }
}
