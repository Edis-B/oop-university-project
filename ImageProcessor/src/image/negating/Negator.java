package image.negating;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

import java.util.List;

public interface Negator<T extends InMemoryImage> {
    InMemoryImage monochrome(T original);
    List<FormatType> getSupportedFormats();
}
