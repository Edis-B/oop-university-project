package image.grayscaling;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.RgbImage;
import image.signatures.FormatType;

import java.util.List;

public interface Grayscaler<T extends InMemoryImage> {
    InMemoryImage grayscale(T original);
    List<FormatType> getSupportedFormats();
}
