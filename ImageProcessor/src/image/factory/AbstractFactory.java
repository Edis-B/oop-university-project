package image.factory;

import image.images_in_memory.InMemoryImage;
import image.manipulators.ImageManipulator;
import image.signatures.FormatType;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFactory<T, C> implements ClassFactory<T, C> {
    protected final Map<C, Class<T>> map
            = new HashMap<>();

    @Override
    public Class<T> search(C type) {
        return map.get(type);
    }

    @Override
    public void register(C type, Class<T> clazz) {
        map.put(type, clazz);
    }
}
