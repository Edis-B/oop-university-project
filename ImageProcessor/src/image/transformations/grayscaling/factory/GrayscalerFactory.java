package image.transformations.grayscaling.factory;

import image.transformations.grayscaling.Grayscaler;
import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

import java.util.HashMap;
import java.util.Map;

public class GrayscalerFactory {
    private final Map<FormatType, Grayscaler<? extends InMemoryImage>> grayscalerMap
            = new HashMap<>();

    private GrayscalerFactory() { }

    private static GrayscalerFactory instance;
    public static GrayscalerFactory getInstance() {
        if (instance == null)
            instance = new GrayscalerFactory();

        return instance;
    }

    public void register(FormatType formatType, Grayscaler<? extends InMemoryImage> grayscaler) {
        grayscalerMap.put(formatType, grayscaler);
    }

    public Grayscaler<?> getGrayscaler(FormatType formatType) {
        return grayscalerMap.get(formatType);
    }
}
