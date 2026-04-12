package image.manipulators.transformations.negative;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.ppm.InMemoryPpm;
import image.images_in_memory.ppm.InMemoryPpmAscii;
import image.images_in_memory.ppm.InMemoryPpmBinary;
import image.signatures.FormatType;
import util.Color;

import java.util.List;

public class PpmNegator implements Negator<InMemoryPpm> {
    @Override
    public InMemoryImage transform(InMemoryPpm original) {
        int width = original.getWidth(),
                height = original.getHeight();

        short maxVal = original.getMaxValue();

        InMemoryPpm negativeImage;
        switch (original.getFormat()) {
            case ASCII_PPM -> negativeImage = new InMemoryPpmAscii(width, height, maxVal);
            case BINARY_PPM -> negativeImage = new InMemoryPpmBinary(width, height, maxVal);
            default -> throw new ApplicationException("Improper image file to negative!");
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                negativeImage.setPixel(i, j,
                        negatePixel(negativeImage.getPixel(i, j), maxVal));
            }
        }

        return negativeImage;
    }

    private Color negatePixel(Color color, short maxVal) {
        return new Color(
                (short) (maxVal - color.getRed()),
                (short) (maxVal - color.getGreen()),
                (short) (maxVal - color.getBlue())
        );
    }

    @Override
    public List<FormatType> getSupportedFormats() {
        return List.of(
                FormatType.ASCII_PPM,
                FormatType.BINARY_PPM
        );
    }
}
