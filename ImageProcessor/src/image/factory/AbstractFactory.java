package image.factory;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFactory<T, C> implements ClassFactory<T, C> {
    protected final Map<C, Class<T>> map
            = new HashMap<>();

    @Override
    public Class<T> search(C query) {
        return map.get(query);
    }

    @Override
    public void register(C query, Class<T> transformerClass) {
        map.put(query, transformerClass);
    }
}
