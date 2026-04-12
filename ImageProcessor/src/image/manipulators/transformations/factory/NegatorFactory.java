package image.manipulators.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.manipulators.transformations.negative.Negator;

public class NegatorFactory extends TransformerFactory<Negator<InMemoryImage>> {
    @Override
    public Class<Negator<InMemoryImage>> getClazz() {
        //noinspection unchecked
        return (Class<Negator<InMemoryImage>>) (Class<?>) Negator.class;
    }
}
