package image.io.serializers.netpbm.pbm;

import exceptions.ApplicationException;
import image.images_in_memory.netpbm.pbm.InMemoryPbmBinary;
import image.io.serializers.netpbm.NetpbmSerializer;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

import java.io.BufferedOutputStream;
import java.io.IOException;

@SupportedFormats({FormatType.BINARY_PBM})
public class BinaryPbmSerializer extends PbmSerializer<InMemoryPbmBinary> {
    @Override
    protected void serializeBody(BufferedOutputStream bos, InMemoryPbmBinary image) {
        int width = image.getWidth(), height = image.getHeight();

        int i = 0, j = 0;
        try {
            for (i = 0; i < height; i++) {
                byte currByte = 0, ctr = 7;
                for (j = 0; j < width; j++) {
                    byte bitValue = (byte) (image.getPixel(i, j) ? 1 : 0);
                    currByte |= (byte) (bitValue << ctr);
                    ctr--;
                    if (ctr == -1) {
                        ctr = 7;
                        bos.write(currByte);
                        currByte = 0;
                    }
                }
                if (ctr != 7) bos.write(currByte);
            }
        } catch (IOException e) {
            throw new ApplicationException(String.format("Error writing to file at position (%d, %d)!", i, j), e);
        }
    }
}
