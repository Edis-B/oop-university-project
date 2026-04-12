package image.manipulators.transformations;

import image.images_in_memory.InMemoryImage;
import image.manipulators.ImageManipulator;
import image.signatures.FormatType;

import java.util.List;

public interface ImageTransformer<T extends InMemoryImage>  extends ImageManipulator<T> {
    InMemoryImage transform(T original);
}
