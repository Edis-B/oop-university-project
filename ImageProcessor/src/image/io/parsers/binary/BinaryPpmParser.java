package image.io.parsers.binary;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.ppm.InMemoryPpmBinary;
import image.signatures.FormatType;
import util.Color;

import java.io.BufferedInputStream;
import java.io.IOException;

public class BinaryPpmParser extends NetpbmBinaryParser {
    @Override
    public FormatType getSupportedFormat() {
        return FormatType.BINARY_PPM;
    }

    @Override
    protected boolean requiresMaxValue() {
        return true;
    }

    @Override
    protected InMemoryImage readPixels(BufferedInputStream bis, int width, int height, short maxColor) {
        InMemoryPpmBinary image = new InMemoryPpmBinary(width, height, maxColor);

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                try {
                    short r = (short) bis.read();
                    short g = (short) bis.read();
                    short b = (short) bis.read();

                    if (r == -1 || g == -1 || b == -1)
                        throw new ApplicationException(String.format(
                                "Unexpected EOF: Premature end of file at pixel (%d, %d).", j, i));

                    image.setPixel(i, j, new Color(r, g, b));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        return image;
    }
}
