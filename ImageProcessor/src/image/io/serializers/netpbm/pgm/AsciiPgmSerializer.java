package image.io.serializers.netpbm.pgm;

import exceptions.ApplicationException;
import image.images_in_memory.netpbm.pgm.InMemoryPgmAscii;
import image.io.serializers.netpbm.MaxValuedSerializer;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SupportedFormats({FormatType.ASCII_PGM})
public class AsciiPgmSerializer extends MaxValuedSerializer<InMemoryPgmAscii> {
    @Override
    protected void serializeBody(BufferedOutputStream bos, InMemoryPgmAscii image) {
        int width = image.getWidth(), height = image.getHeight();

        int i = 0, j = 0;
        try {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    var pixel = String.valueOf(image.getPixel(i, j));
                    for (var bait : pixel.getBytes(StandardCharsets.UTF_8))
                        bos.write(bait);

                    if (j != width - 1)
                        bos.write(' ');
                }
                bos.write('\n');
            }
        } catch (IOException e) {
            throw new ApplicationException(String.format("Error writing to file at position (%d, %d)!", i, j), e);
        }
    }
}
