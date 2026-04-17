package image.io.serializers.netpbm.pbm;

import exceptions.ApplicationException;
import image.images_in_memory.netpbm.pbm.InMemoryPbmAscii;
import image.io.serializers.netpbm.NetpbmSerializer;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

import java.io.BufferedOutputStream;
import java.io.IOException;

@SupportedFormats({FormatType.ASCII_PBM})
public class AsciiPbmSerializer extends PbmSerializer<InMemoryPbmAscii> {
    @Override
    protected void serializeBody(BufferedOutputStream bos, InMemoryPbmAscii image) {
        int width = image.getWidth(), height = image.getHeight();

        int i = 0, j = 0;
        try {
            for (i = 0; i < height; i++) {
                for (j = 0; j < width; j++) {
                    bos.write(
                            image.getPixel(i, j) ? 1 : 0
                    );

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
