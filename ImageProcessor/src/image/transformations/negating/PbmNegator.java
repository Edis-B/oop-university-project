package image.transformations.negating;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.pbm.InMemoryPbm;
import image.images_in_memory.pbm.InMemoryPbmAscii;
import image.images_in_memory.pbm.InMemoryPbmBinary;
import image.signatures.FormatType;

import java.util.List;

public class PbmNegator implements Negator<InMemoryPbm> {
    @Override
    public InMemoryImage transform(InMemoryPbm original) {
        int width = original.getWidth(),
                height = original.getHeight();

        short maxVal = original.getMaxValue();

        InMemoryPbm negativeImage;
        switch (original.getFormat()) {
            case ASCII_PGM -> negativeImage = new InMemoryPbmAscii(width, height, maxVal);
            case BINARY_PGM -> negativeImage = new InMemoryPbmBinary(width, height, maxVal);
            default -> throw new ApplicationException("Improper image file to negative!");
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                negativeImage.setPixel(i, j, !negativeImage.getPixel(i, j));
            }
        }

        return negativeImage;
    }

    @Override
    public List<FormatType> getSupportedFormats() {
        return List.of();
    }
}
