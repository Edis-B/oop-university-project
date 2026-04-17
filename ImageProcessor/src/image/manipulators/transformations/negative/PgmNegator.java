package image.manipulators.transformations.negative;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.pgm.InMemoryPgm;
import image.images_in_memory.netpbm.pgm.InMemoryPgmAscii;
import image.images_in_memory.netpbm.pgm.InMemoryPgmBinary;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PGM, FormatType.BINARY_PGM})
public class PgmNegator implements Negator<InMemoryPgm> {
    @Override
    public InMemoryImage transform(InMemoryPgm original) {
        int width = original.getWidth(),
                height = original.getHeight();

        short maxVal = original.getMaxValue();

        InMemoryPgm negativeImage;
        switch (original.getFormat()) {
            case ASCII_PGM -> negativeImage = new InMemoryPgmAscii(width, height, maxVal);
            case BINARY_PGM -> negativeImage = new InMemoryPgmBinary(width, height, maxVal);
            default -> throw new ApplicationException("Improper image file to negative!");
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                negativeImage.setPixel(i, j, (short)
                        (maxVal - negativeImage.getPixel(i, j)));
            }
        }

        return negativeImage;
    }
}
