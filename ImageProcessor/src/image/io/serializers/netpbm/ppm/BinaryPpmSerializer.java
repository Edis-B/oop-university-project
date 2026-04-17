package image.io.serializers.netpbm.ppm;

import exceptions.ApplicationException;
import image.images_in_memory.netpbm.ppm.InMemoryPpmBinary;
import image.io.serializers.netpbm.MaxValuedSerializer;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;
import util.Color;

import java.io.BufferedOutputStream;
import java.io.IOException;

@SupportedFormats({FormatType.BINARY_PPM})
public class BinaryPpmSerializer extends MaxValuedSerializer<InMemoryPpmBinary> {
    @Override
    protected void serializeBody(BufferedOutputStream bos, InMemoryPpmBinary image) {
        int width = image.getWidth(), height = image.getHeight();

        int i = 0, j = 0;
        try {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    Color pixel = image.getPixel(i, j);

                    bos.write((byte) (pixel.getRed()));
                    bos.write((byte) (pixel.getGreen()));
                    bos.write((byte) (pixel.getBlue()));
                }
            }
        } catch (IOException e) {
            throw new ApplicationException(String.format("Error writing to file at position (%d, %d)!", i, j), e);
        }
    }
}
