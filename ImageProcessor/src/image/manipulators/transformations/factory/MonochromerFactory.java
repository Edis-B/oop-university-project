package image.manipulators.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.manipulators.transformations.monochrome.Monochromer;

public class MonochromerFactory extends TransformerFactory<Monochromer<InMemoryImage>> {
    @Override
    public Class<Monochromer<InMemoryImage>> getClazz() {
        //noinspection unchecked
        return (Class<Monochromer<InMemoryImage>>) (Class<?>) Monochromer.class;
    }
}
