package image.io.serializers.netpbm.ppm;

import exceptions.ApplicationException;
import image.images_in_memory.netpbm.ppm.InMemoryPpmAscii;
import image.io.serializers.netpbm.MaxValuedSerializer;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;
import util.Color;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SupportedFormats({FormatType.ASCII_PPM})
public class AsciiPpmSerializer extends MaxValuedSerializer<InMemoryPpmAscii> {

    @Override
    protected void serializeBody(BufferedOutputStream bos, InMemoryPpmAscii image) {
        int width = image.getWidth(), height = image.getHeight();

        int i = 0, j = 0;
        try {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    Color pixel = image.getPixel(i, j);
                    short[] colors = {pixel.getRed(), pixel.getGreen(), pixel.getBlue()};

                    for (int k = 0; k < 3; k++) {
                        for (byte bait : String.valueOf(colors[k])
                                .getBytes(StandardCharsets.UTF_8)) {
                            bos.write(bait);
                        }

                        if (j != width - 1 && k != 2)
                            bos.write(' ');
                    }
                }
                bos.write('\n');
            }
        } catch (IOException e) {
            throw new ApplicationException(String.format("Error writing to file at position (%d, %d)!", i, j), e);
        }
    }
}
