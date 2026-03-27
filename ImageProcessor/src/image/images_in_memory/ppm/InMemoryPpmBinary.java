package image.images_in_memory.ppm;

import image.signatures.FormatType;

public class InMemoryPpmBinary extends InMemoryPpm {
    public InMemoryPpmBinary(int width, int height, int maxValue) {
        super(width, height, maxValue);
    }

    public InMemoryPpmBinary(int width, int height) {
        super(width, height);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.BINARY_PPM;
    }
}
