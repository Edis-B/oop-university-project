package image.io.parsers;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

import java.io.BufferedInputStream;

public interface ImageParser {
    InMemoryImage parse(BufferedInputStream bis);
    FormatType getSupportedFormat();
}