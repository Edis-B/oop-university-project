package image.transformations.grayscale;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.ppm.InMemoryPpm;
import image.images_in_memory.ppm.InMemoryPpmAscii;
import image.images_in_memory.ppm.InMemoryPpmBinary;
import image.signatures.FormatType;
import util.Color;

import java.util.List;

public class PpmGrayscaler implements Grayscaler<InMemoryPpm> {

    public PpmGrayscaler() {
    }

    @Override
    public InMemoryImage transform(InMemoryPpm original) {
        int width = original.getWidth(),
                height = original.getHeight();

        short maxVal = original.getMaxValue();

        InMemoryPpm grayImage;
        switch (original.getFormat()) {
            case ASCII_PPM -> grayImage = new InMemoryPpmAscii(width, height, maxVal);
            case BINARY_PPM -> grayImage = new InMemoryPpmBinary(width, height, maxVal);
            default -> throw new ApplicationException("Improper image file to grayscale!");
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color oldColor = original.getPixel(j, i);
                short gray =
                        (short) (oldColor.getRed() * 0.299 + oldColor.getGreen() * 0.587 + oldColor.getBlue() * 0.114);

                grayImage.setPixel(i, j, new Color(gray, gray, gray));
            }
        }

        return grayImage;
    }

    @Override
    public List<FormatType> getSupportedFormats() {
        return List.of(
                FormatType.ASCII_PPM,
                FormatType.BINARY_PPM
        );
    }
}
