package image.parsers.ascii;

import image.images_in_memory.pgm.InMemoryPgmAscii;
import image.parsers.ImageParser;

import java.io.BufferedInputStream;

public class AsciiPgmParser implements ImageParser {
    @Override
    public InMemoryPgmAscii parse(BufferedInputStream bis) {
        return null;
    }

    @Override
    public String getSupportedFormat() {
        return "P2";
    }
}
