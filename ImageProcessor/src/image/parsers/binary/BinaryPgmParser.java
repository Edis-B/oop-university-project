package image.parsers.binary;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryNetpbm;
import image.images_in_memory.pgm.InMemoryPgmBinary;
import image.signatures.FormatType;

import java.io.BufferedInputStream;
import java.io.IOException;

public class BinaryPgmParser extends NetpbmBinaryParser {
    @Override
    public FormatType getSupportedFormat() {
        return FormatType.BINARY_PGM;
    }

    @Override
    protected boolean requiresMaxValue() {
        return true;
    }

    @Override
    protected InMemoryNetpbm readPixels(BufferedInputStream bis, int width, int height, int maxColor) {
        InMemoryPgmBinary image = new InMemoryPgmBinary(width, height, maxColor);

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                try {
                    int b;
                    b = bis.read();

                    if (b == -1)
                        throw new ApplicationException(String.format(
                                "Unexpected EOF: Premature end of file at pixel (%d, %d).", j, i));

                    image.setPixel(i, j, (short) b);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        return image;
    }
}
