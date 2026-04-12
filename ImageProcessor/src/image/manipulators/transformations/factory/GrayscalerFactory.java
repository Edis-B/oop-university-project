package image.manipulators.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.manipulators.transformations.grayscale.Grayscaler;

public class GrayscalerFactory extends TransformerFactory<Grayscaler<InMemoryImage>> {
    @Override
    public Class<Grayscaler<InMemoryImage>> getClazz() {
        //noinspection unchecked
        return (Class<Grayscaler<InMemoryImage>>) (Class<?>) Grayscaler.class;
    }
}
