package image.parsers.ascii;

import image.images_in_memory.pbm.InMemoryPbmAscii;
import image.parsers.ImageParser;

import java.io.BufferedInputStream;

public class AsciiPbmParser implements ImageParser {
    @Override
    public InMemoryPbmAscii parse(BufferedInputStream bis) {
        return null;
    }

    @Override
    public String getSupportedFormat() {
        return "P1";
    }
}
