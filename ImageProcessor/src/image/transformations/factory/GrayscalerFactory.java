package image.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.transformations.grayscale.Grayscaler;

public class GrayscalerFactory extends AbstractTransformerFactory<Grayscaler<InMemoryImage>> {
    @Override
    public Class<Grayscaler<InMemoryImage>> getTransformerType() {
        //noinspection unchecked
        return (Class<Grayscaler<InMemoryImage>>) (Class<?>) Grayscaler.class;
    }
}
