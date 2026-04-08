package image.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import image.transformations.ImageTransformer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTransformerFactory implements TransformerFactory
{
    protected final Map<FormatType, ImageTransformer<? extends InMemoryImage>> tranformerMap
            = new HashMap<>();

    @Override
    public ImageTransformer<? extends InMemoryImage> getTransformer(FormatType formatType) {
        return tranformerMap.get(formatType);
    }

    @Override
    public void register(FormatType formatType, ImageTransformer<? extends InMemoryImage> imageTransformer) {
        tranformerMap.put(formatType, imageTransformer);
    }
}
