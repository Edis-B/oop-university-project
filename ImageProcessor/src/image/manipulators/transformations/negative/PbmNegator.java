package image.manipulators.transformations.negative;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.pbm.InMemoryPbm;
import image.images_in_memory.netpbm.pbm.InMemoryPbmAscii;
import image.images_in_memory.netpbm.pbm.InMemoryPbmBinary;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PBM, FormatType.BINARY_PBM})
public class PbmNegator implements Negator<InMemoryPbm> {
    @Override
    public InMemoryImage transform(InMemoryPbm original) {
        int width = original.getWidth(),
                height = original.getHeight();

        InMemoryPbm negativeImage;
        switch (original.getFormat()) {
            case ASCII_PBM -> negativeImage = new InMemoryPbmAscii(width, height);
            case BINARY_PBM -> negativeImage = new InMemoryPbmBinary(width, height);
            default -> throw new ApplicationException("Improper image file to negative!");
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                negativeImage.setPixel(i, j, !original.getPixel(i, j));
            }
        }

        return negativeImage;
    }
}
