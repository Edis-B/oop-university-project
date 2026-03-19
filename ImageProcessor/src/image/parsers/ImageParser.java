package image.parsers;

import image.images_in_memory.InMemoryImage;

import java.io.BufferedInputStream;
import java.io.IOException;

public interface ImageParser {
    InMemoryImage parse(BufferedInputStream bis) throws IOException;
    String getSupportedFormat();
}