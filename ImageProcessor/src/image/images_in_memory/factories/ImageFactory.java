package image.images_in_memory.factories;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryNetpbm;
import image.images_in_memory.ppm.InMemoryPpmAscii;
import image.images_in_memory.ppm.InMemoryPpmBinary;
import image.signatures.FormatType;

import java.util.HashMap;
import java.util.Map;

public class ImageFactory {
    private final Map<FormatType, ImageCreator> registry = new HashMap<>();

    private interface ImageCreator {
        InMemoryNetpbm create(int w, int h, int maxV);
    }

    public ImageFactory() {
        registry.put(FormatType.ASCII_PPM, (w, h, v) -> new InMemoryPpmAscii(w, h, v));
        registry.put(FormatType.BINARY_PPM, (w, h, v) -> new InMemoryPpmBinary(w, h, v));
    }

    public InMemoryNetpbm create(FormatType type, int w, int h, int maxV) {
        if (!registry.containsKey(type)) {
            throw new ApplicationException("Format not registered: " + type);
        }

        return registry.get(type).create(w, h, maxV);
    }
}
