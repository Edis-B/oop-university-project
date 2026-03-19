package image.parsers.binary;

import image.images_in_memory.pgm.InMemoryPgmBinary;
import image.parsers.ImageParser;

import java.io.BufferedInputStream;

public class BinaryPgmParser implements ImageParser {
    @Override
    public InMemoryPgmBinary parse(BufferedInputStream bis) {
        return null;
    }

    @Override
    public String getSupportedFormat() {
        return "P5";
    }
}
