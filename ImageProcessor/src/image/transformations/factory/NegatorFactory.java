package image.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.transformations.negating.Negator;

public class NegatorFactory extends AbstractTransformerFactory<Negator<InMemoryImage>> {
    @Override
    public Class<Negator<InMemoryImage>> getTransformerType() {
        //noinspection unchecked
        return (Class<Negator<InMemoryImage>>) (Class<?>) Negator.class;
    }
}
