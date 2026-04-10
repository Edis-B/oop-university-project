package image.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.transformations.monochroming.Monochromer;

public class MonochromerFactory extends AbstractTransformerFactory<Monochromer<InMemoryImage>> {
    @Override
    public Class<Monochromer<InMemoryImage>> getTransformerType() {
        //noinspection unchecked
        return (Class<Monochromer<InMemoryImage>>) (Class<?>) Monochromer.class;
    }
}
