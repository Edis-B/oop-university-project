package image.transformations.factory;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import image.transformations.ImageTransformer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTransformerFactory<T extends ImageTransformer<? extends InMemoryImage>> implements TransformerFactory<T> {
    protected final Map<FormatType, Class<T>> tranformerMap
            = new HashMap<>();

    @Override
    public Class<T> getTransformer(FormatType formatType) {
        return tranformerMap.get(formatType);
    }

    @Override
    public void register(FormatType formatType, Class<T> transformerClass) {
        tranformerMap.put(formatType, transformerClass);
    }
}
