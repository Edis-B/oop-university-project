package image.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.transformations.rotate.Rotator;

public class RotatorFactory extends AbstractTransformerFactory<Rotator<InMemoryImage>> {
    @Override
    public Class<Rotator<InMemoryImage>> getTransformerType() {
        //noinspection unchecked
        return (Class<Rotator<InMemoryImage>>) (Class<?>) Rotator.class;
    }
}
