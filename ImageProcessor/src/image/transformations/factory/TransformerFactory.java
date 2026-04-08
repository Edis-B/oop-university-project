package image.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import image.transformations.ImageTransformer;

public interface TransformerFactory {
    ImageTransformer<? extends InMemoryImage> getTransformer(FormatType type);

    void register(FormatType formatType, ImageTransformer<? extends InMemoryImage> imageTransformer);
}
