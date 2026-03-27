package image.images_in_memory.ppm;

import image.signatures.FormatType;

public class InMemoryPpmAscii extends InMemoryPpm {
    public InMemoryPpmAscii(int width, int height, int maxValue) {
        super(width, height, maxValue);
    }

    public InMemoryPpmAscii(int width, int height) {
        super(width, height);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.ASCII_PPM;
    }

}

