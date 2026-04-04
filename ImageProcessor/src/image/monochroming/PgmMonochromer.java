package image.monochroming;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.pgm.InMemoryPgm;
import image.images_in_memory.pgm.InMemoryPgmAscii;
import image.images_in_memory.pgm.InMemoryPgmBinary;
import image.signatures.FormatType;

import java.util.List;

public class PgmMonochromer implements Monochromer<InMemoryPgm> {
    @Override
    public InMemoryImage monochrome(InMemoryPgm original) {
        long graySum = 0;
        int width = original.getWidth(),
                height = original.getHeight();

        short maxVal = original.getMaxValue();

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                graySum += original.getPixel(j, i);

        int threshold = Math.toIntExact(graySum / (width * height));
        InMemoryPgm monochromeImage;
        switch (original.getFormat()) {
            case ASCII_PGM -> monochromeImage = new InMemoryPgmAscii(width, height, maxVal);
            case BINARY_PGM -> monochromeImage = new InMemoryPgmBinary(width, height, maxVal);
            default -> throw new ApplicationException("Improper image file to grayscale!");
        }

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                var pixel = monochromeImage.getPixel(i, j);
                monochromeImage.setPixel(i, j, pixel >= threshold ? maxVal : 0);
            }

        return monochromeImage;
    }

    @Override
    public List<FormatType> getSupportedFormats() {
        return List.of(
                FormatType.ASCII_PGM,
                FormatType.BINARY_PGM
        );
    }
}
