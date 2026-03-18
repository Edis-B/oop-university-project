package image.parsers;

import image.images_in_memory.InMemoryImage;

import java.io.BufferedInputStream;

public interface ImageParser {
    InMemoryImage parse(BufferedInputStream bis);
}