package image.transformations.negating.factory;

import image.images_in_memory.InMemoryImage;
import image.transformations.negating.Negator;
import image.signatures.FormatType;

import java.util.HashMap;
import java.util.Map;

public class NegatorFactory {
    private final Map<FormatType, Negator<? extends InMemoryImage>> negatorMap
            = new HashMap<>();

    private NegatorFactory() {
    }

    private static NegatorFactory instance;

    public static NegatorFactory getInstance() {
        if (instance == null)
            instance = new NegatorFactory();

        return instance;
    }

    public void register(FormatType formatType, Negator<? extends InMemoryImage> negator) {
        negatorMap.put(formatType, negator);
    }

    public Negator<? extends InMemoryImage> getNegator(FormatType formatType) {
        return negatorMap.get(formatType);
    }
}
