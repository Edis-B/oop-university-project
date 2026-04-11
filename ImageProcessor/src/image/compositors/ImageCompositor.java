package image.compositors;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import session.ImageContext;

import java.util.List;

public interface ImageCompositor<T extends InMemoryImage> {
    void execute(ImageContext imageContext);
    List<FormatType> getSupportedFormats();
}
