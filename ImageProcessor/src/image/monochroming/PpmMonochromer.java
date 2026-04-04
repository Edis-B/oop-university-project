package image.monochroming;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.images_in_memory.ppm.InMemoryPpm;
import image.images_in_memory.ppm.InMemoryPpmAscii;
import image.images_in_memory.ppm.InMemoryPpmBinary;
import image.signatures.FormatType;
import util.Color;

import java.util.List;

public class PpmMonochromer implements Monochromer<InMemoryPpm> {

    @Override
    public InMemoryImage monochrome(InMemoryPpm original) {
        long graySum = 0;
        int width = original.getWidth(),
                height = original.getHeight();

        short maxVal = original.getMaxValue();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = original.getPixel(j, i);
                graySum += calculateLuminance(color);
            }
        }

        int threshold = Math.toIntExact(graySum / (width * height));
        InMemoryPpm monochromeImage;
        switch (original.getFormat()) {
            case ASCII_PPM -> monochromeImage = new InMemoryPpmAscii(width, height, maxVal);
            case BINARY_PPM -> monochromeImage = new InMemoryPpmBinary(width, height, maxVal);
            default -> throw new ApplicationException("Improper image file to grayscale!");
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = original.getPixel(j, i);
                short gray = calculateLuminance(color);

                Color newColor = gray >= threshold ?
                        new Color(maxVal, maxVal, maxVal) :
                        new Color((short) 0, (short) 0, (short) 0);

                monochromeImage.setPixel(i, j, newColor);
            }
        }

        return monochromeImage;
    }

    private short calculateLuminance(Color color) {
        return (short) (color.getRed() * 0.299 + color.getGreen() * 0.587 + color.getBlue() * 0.114);
    }

    @Override
    public List<FormatType> getSupportedFormats() {
        return List.of(
                FormatType.ASCII_PPM,
                FormatType.BINARY_PPM
        );
    }
}
