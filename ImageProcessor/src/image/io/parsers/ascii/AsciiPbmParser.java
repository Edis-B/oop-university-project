package image.io.parsers.ascii;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.pbm.InMemoryPbmAscii;
import image.signatures.FormatType;

import java.io.BufferedInputStream;

public class AsciiPbmParser extends NetpbmAsciiParser {
    @Override
    protected boolean requiresMaxValue() {
        return false;
    }

    @Override
    protected InMemoryImage readPixels(BufferedInputStream bis, int width, int height, short maxColor) {
        InMemoryPbmAscii image = new InMemoryPbmAscii(width, height);

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                int b = getNextInt(bis);
                if (b == -1)
                    throw new ApplicationException(String.format(
                            "Unexpected EOF: Premature end of file at pixel (%d, %d).", j, i));

                image.setPixel(i, j, b > 0);
            }

        return image;
    }

    @Override
    public FormatType getSupportedFormat() {
        return FormatType.ASCII_PBM;
    }
}
