package image.manipulators.compositors;

import image.images_in_memory.InMemoryImage;
import image.manipulators.ImageManipulator;
import image.signatures.FormatType;
import session.ImageContext;

import java.util.List;

public interface ImageCompositor<T extends InMemoryImage> extends ImageManipulator<T> {
    void execute(ImageContext imageContext);
}
