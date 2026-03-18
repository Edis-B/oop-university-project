package image.parsers.ascii;

import image.images_in_memory.InMemoryPpmAscii;
import image.parsers.ImageParser;

import java.io.BufferedInputStream;

public class AsciiPpmParser implements ImageParser {
    @Override
    public InMemoryPpmAscii parse(BufferedInputStream bis) {
        InMemoryPpmAscii image = new InMemoryPpmAscii();

        image.setMagicNumber(Integer.parseInt(sc.next()));

        while (sc.hasNext()) {

        }

        return image;
    }
}
