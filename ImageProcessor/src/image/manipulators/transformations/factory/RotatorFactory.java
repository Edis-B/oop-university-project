package image.manipulators.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.manipulators.transformations.rotate.Rotator;

public class RotatorFactory extends TransformerFactory<Rotator<InMemoryImage>> {
    @Override
    public Class<Rotator<InMemoryImage>> getClazz() {
        //noinspection unchecked
        return (Class<Rotator<InMemoryImage>>) (Class<?>) Rotator.class;
    }
}
