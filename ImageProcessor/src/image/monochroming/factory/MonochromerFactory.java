package image.monochroming.factory;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.monochroming.Monochromer;
import image.signatures.FormatType;

import java.util.HashMap;
import java.util.Map;

public class MonochromerFactory {
    private final Map<FormatType, Monochromer<? extends InMemoryImage>> monochromerMap
            = new HashMap<>();

    private MonochromerFactory() {
    }

    private static MonochromerFactory instance;

    public static MonochromerFactory getInstance() {
        if (instance == null)
            instance = new MonochromerFactory();

        return instance;
    }

    public void register(FormatType formatType, Monochromer<? extends InMemoryImage> monochromer) {
        monochromerMap.put(formatType, monochromer);
    }

    public Monochromer<?> getMonochromer(FormatType formatType) {
        return monochromerMap.get(formatType);
    }
}
