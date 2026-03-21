package image.parsers.binary;

import image.images_in_memory.pbm.InMemoryPbmBinary;
import image.parsers.ImageParser;
import image.parsers.ascii.NetpbmAsciiParser;

import java.io.BufferedInputStream;

public class BinaryPbmParser extends NetpbmBinaryParser {
    @Override
    public InMemoryPbmBinary parse(BufferedInputStream bis) {
        return null;
    }

    @Override
    public String getSupportedFormat() {
        return "P4";
    }
}
