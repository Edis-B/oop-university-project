package image.parsers.ascii;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryNetpbm;
import image.images_in_memory.ppm.InMemoryPpmAscii;
import image.signatures.FormatType;
import util.Color;

import java.io.BufferedInputStream;

public class AsciiPpmParser extends NetpbmAsciiParser {
    @Override
    protected boolean requiresMaxValue() {
        return true;
    }

    @Override
    public FormatType getSupportedFormat() {
        return FormatType.ASCII_PPM;
    }

    @Override
    protected InMemoryNetpbm readPixels(BufferedInputStream bis, int width, int height, int maxColor) {
        InMemoryPpmAscii image = new InMemoryPpmAscii(width, height, maxColor);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                short r = (short) getNextInt(bis);
                short g = (short) getNextInt(bis);
                short b = (short) getNextInt(bis);

                if (r == -1 || g == -1 || b == -1)
                    throw new ApplicationException(String.format(
                            "Unexpected EOF: Premature end of file at pixel (%d, %d).", j, i));

                image.setPixel(i, j, new Color(r, g, b));
            }
        }

        return image;
    }
}
