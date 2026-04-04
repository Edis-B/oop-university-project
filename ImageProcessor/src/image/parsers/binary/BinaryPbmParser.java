package image.parsers.binary;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryNetpbm;
import image.images_in_memory.pbm.InMemoryPbmBinary;
import image.signatures.FormatType;

import java.io.BufferedInputStream;
import java.io.IOException;

public class BinaryPbmParser extends NetpbmBinaryParser {
    @Override
    public FormatType getSupportedFormat() {
        return FormatType.BINARY_PBM;
    }

    @Override
    protected boolean requiresMaxValue() {
        return false;
    }

    @Override
    protected InMemoryNetpbm readPixels(BufferedInputStream bis, int width, int height, short maxColor) {
        InMemoryPbmBinary image = new InMemoryPbmBinary(width, height);

        int totalBits = width * height,
                bytesPerRow = (width + 7) / 8,
                totalBytesToRead = bytesPerRow * height;

        try {
            byte[] data = bis.readNBytes(totalBytesToRead);

            if (data.length < totalBytesToRead) {
                throw new ApplicationException("Unexpected EOF: File ended prematurely.");
            }

            boolean[] pixels = new boolean[totalBits];
            int ctr = 0;

            for (int row = 0; row < height; row++) {
                int startByte = bytesPerRow * row;
                for (int currBit = 0; currBit < width; currBit++) {
                    int currByte = startByte + (currBit / 8),
                            bitPos = currBit % 8;

                    pixels[ctr++] = (data[currByte] & (128 >> bitPos)) != 0;
                }
            }

            if (ctr < totalBits) {
                throw new ApplicationException("Unexpected EOF: File ended prematurely.");
            }

            for (int i = 0; i < height; i++) {
                int startIndex = i * width;
                for (int j = 0; j < width; j++) {
                    int index = startIndex + j;
                    image.setPixel(i, j, pixels[index]);
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("Error reading pixels", e);
        }

        return image;
    }
}
