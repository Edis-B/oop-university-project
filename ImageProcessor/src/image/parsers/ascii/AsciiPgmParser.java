package image.parsers.ascii;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.pbm.InMemoryPbmAscii;
import image.images_in_memory.pgm.InMemoryPgmAscii;
import image.signatures.FormatType;

import java.io.BufferedInputStream;

public class AsciiPgmParser extends NetpbmAsciiParser {
    @Override
    protected boolean requiresMaxValue() {
        return true;
    }

    @Override
    public FormatType getSupportedFormat() {
        return FormatType.ASCII_PGM;
    }

    @Override
    protected InMemoryImage readPixels(BufferedInputStream bis, int width, int height, int maxColor) {
        InMemoryPgmAscii image = new InMemoryPgmAscii(width, height, maxColor);

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                int b = getNextInt(bis);
                if (b == -1)
                    throw new ApplicationException(String.format(
                            "Unexpected EOF: Premature end of file at pixel (%d, %d).", j, i));

                image.setPixel(j, i, (short) b);
            }

        return image;
    }
}
