package image.parsers.binary;

import image.images_in_memory.pbm.InMemoryPbmBinary;
import image.parsers.ImageParser;

import java.io.BufferedInputStream;

public class BinaryPbmParser implements ImageParser {
    @Override
    public InMemoryPbmBinary parse(BufferedInputStream bis) {
        return null;
    }

    @Override
    public String getSupportedFormat() {
        return "P4";
    }
}
