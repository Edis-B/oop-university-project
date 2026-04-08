package image.transformations;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

import java.util.List;

public interface ImageTransformer<T extends InMemoryImage> {
    InMemoryImage transform(T original);
    List<FormatType> getSupportedFormats();
}
