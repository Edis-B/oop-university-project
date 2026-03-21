package image.parsers.ascii;

import image.images_in_memory.ppm.InMemoryPpmAscii;
import image.parsers.ImageParser;
import util.Color;
import util.Triple;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class AsciiPpmParser extends NetpbmAsciiParser {
    @Override
    public InMemoryPpmAscii parse(BufferedInputStream bis) throws IOException {
        // magic
        String magicNumber = readMagic(bis);

        // width height
        short width = (short) getNextInt(bis);
        short height = (short) getNextInt(bis);

        // maxValue
        short maxColor = (short) getNextInt(bis);
        InMemoryPpmAscii image = new InMemoryPpmAscii(width, height, maxColor);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Short r = (short) getNextInt(bis);
                Short g = (short) getNextInt(bis);
                Short b = (short) getNextInt(bis);

                image.setPixel(x, y, new Color(r, g, b));
            }
        }

        return image;
    }

    @Override
    public String getSupportedFormat() {
        return "P3";
    }
}
