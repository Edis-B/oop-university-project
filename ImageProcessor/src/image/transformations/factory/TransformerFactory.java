package image.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import image.transformations.ImageTransformer;

public interface TransformerFactory<T extends ImageTransformer<? extends InMemoryImage>> {
    Class<T> getTransformer(FormatType type);

    Class<T> getTransformerType();

    void register(FormatType formatType, Class<T> imageTransformer);
}
