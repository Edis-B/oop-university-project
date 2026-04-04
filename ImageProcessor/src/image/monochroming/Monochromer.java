package image.monochroming;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

import java.util.List;

public interface Monochromer<T extends InMemoryImage>  {
    InMemoryImage monochrome(T original);
    List<FormatType> getSupportedFormats();
}
