package image.manipulators;

import image.images_in_memory.InMemoryImage;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

import java.util.List;

public interface ImageManipulator<T extends InMemoryImage> {
    default List<FormatType> getSupportedFormats() {
        return List.of(this.getClass().getAnnotation(SupportedFormats.class).value());
    }
}
