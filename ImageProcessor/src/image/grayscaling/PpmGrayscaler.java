package image.grayscaling;

import exceptions.ApplicationException;
import image.images_in_memory.RgbImage;
import image.images_in_memory.ppm.InMemoryPpm;
import image.images_in_memory.ppm.InMemoryPpmAscii;
import image.images_in_memory.ppm.InMemoryPpmBinary;
import image.signatures.FormatType;
import util.Color;

import java.util.List;

public class PpmGrayscaler implements Grayscaler {
    @Override
    public RgbImage grayscale(RgbImage rgbImage) {
        InMemoryPpm original = (InMemoryPpm) rgbImage;
        int height = original.getHeight(),
                width = original.getWidth(),
                maxVal = original.getMaxValue();

        InMemoryPpm grayImage;
        switch (original.getFormat()) {
            case ASCII_PPM -> grayImage = new InMemoryPpmAscii(width, height, maxVal);
            case BINARY_PPM -> grayImage = new InMemoryPpmBinary(width, height, maxVal);
            default -> throw new ApplicationException("Improper image file to grayscale!");
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color oldColor = original.getPixel(j, i);
                short avg = (short) ((oldColor.getRed() + oldColor.getGreen() + oldColor.getBlue()) / 3);

                grayImage.setPixel(j, i, new Color(avg, avg, avg));
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
