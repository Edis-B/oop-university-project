package image.manipulators.transformations.monochrome;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.pgm.InMemoryPgm;
import image.images_in_memory.netpbm.pgm.InMemoryPgmAscii;
import image.images_in_memory.netpbm.pgm.InMemoryPgmBinary;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PGM, FormatType.BINARY_PGM})
public class PgmMonochromer implements Monochromer<InMemoryPgm> {
    @Override
    public InMemoryImage transform(InMemoryPgm original) {
        int width = original.getWidth(),
                height = original.getHeight();

        short maxVal = original.getMaxValue();

        InMemoryPgm monochromeImage;
        switch (original.getFormat()) {
            case ASCII_PGM -> monochromeImage = new InMemoryPgmAscii(width, height, maxVal);
            case BINARY_PGM -> monochromeImage = new InMemoryPgmBinary(width, height, maxVal);
            default -> throw new ApplicationException("Improper image file to grayscale!");
        }

        short threshold = getThreshold(original);
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                var pixel = monochromeImage.getPixel(i, j);
                monochromeImage.setPixel(i, j, pixel >= threshold ? maxVal : 0);
            }

        return monochromeImage;
    }

    private short getThreshold(InMemoryPgm image) {
        int width = image.getWidth(),
                height = image.getHeight();

        long graySum = 0;
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                graySum += image.getPixel(i, j);

        return (short) Math.toIntExact(graySum / (width * height));
    }
}
