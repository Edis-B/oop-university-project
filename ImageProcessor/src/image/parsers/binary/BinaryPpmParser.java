package image.parsers.binary;

import image.images_in_memory.ppm.InMemoryPpmBinary;
import image.parsers.ImageParser;

import java.io.BufferedInputStream;

public class BinaryPpmParser extends NetpbmBinaryParser {
    @Override
    public InMemoryPpmBinary parse(BufferedInputStream bis) {
        return null;
    }

    @Override
    public String getSupportedFormat() {
        return "P6";
    }
}
