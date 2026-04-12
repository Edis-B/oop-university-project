package image.manipulators;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

import java.util.List;

public interface ImageManipulator<T extends InMemoryImage> {
    List<FormatType> getSupportedFormats();

}
