package image.io.serializers.netpbm.pgm;

import exceptions.ApplicationException;
import image.images_in_memory.netpbm.pgm.InMemoryPgmBinary;
import image.io.serializers.netpbm.MaxValuedSerializer;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SupportedFormats({FormatType.BINARY_PGM})
public class BinaryPgmSerializer extends MaxValuedSerializer<InMemoryPgmBinary> {
    @Override
    protected void serializeBody(BufferedOutputStream bos, InMemoryPgmBinary image) {
        int width = image.getWidth(), height = image.getHeight();

        int i = 0, j = 0;
        try {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    byte pixel = (byte) image.getPixel(i, j);
                    bos.write(pixel);
                }
            }
        } catch (IOException e) {
            throw new ApplicationException(String.format("Error writing to file at position (%d, %d)!", i, j), e);
        }
    }
}
