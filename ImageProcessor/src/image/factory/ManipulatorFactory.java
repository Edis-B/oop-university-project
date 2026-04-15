package image.factory;

import image.images_in_memory.InMemoryImage;
import image.manipulators.ImageManipulator;
import image.signatures.FormatType;

import java.util.HashMap;
import java.util.Map;

public abstract class ManipulatorFactory<T extends ImageManipulator<? extends InMemoryImage>> implements ClassFactory<T, FormatType> {
    protected final Map<FormatType, Class<T>> map
            = new HashMap<>();

    @Override
    public Class<T> search(FormatType query) {
        return map.get(query);
    }

    @Override
    public void register(FormatType query, Class<T> transformerClass) {
        map.put(query, transformerClass);
    }
}
