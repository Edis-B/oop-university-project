package image.grayscaling;

import image.images_in_memory.RgbImage;
import image.signatures.FormatType;

import java.util.List;

public interface Grayscaler {
    RgbImage grayscale(RgbImage image);
    List<FormatType> getSupportedFormats();
}
