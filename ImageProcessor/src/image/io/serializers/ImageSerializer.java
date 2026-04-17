package image.io.serializers;

import image.images_in_memory.InMemoryImage;
import image.manipulators.annotation.AnnotationHelper;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

import java.io.BufferedOutputStream;
import java.util.List;

public interface ImageSerializer<T extends InMemoryImage> {
    void serialize(BufferedOutputStream bos, T image);

    default List<FormatType> getSupportedFormats() {
        return AnnotationHelper.getSupportedFormatTypes(this.getClass());
    }
}
