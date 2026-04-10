package image.images_in_memory.ppm;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

public class InMemoryPpmBinary extends InMemoryPpm {
    public InMemoryPpmBinary(int width, int height, short maxValue) {
        super(width, height, maxValue);
    }

    public InMemoryPpmBinary(int width, int height) {
        super(width, height);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.BINARY_PPM;
    }

    @Override
    public InMemoryImage createBlank(int width, int height, short maxValue) {
        return new InMemoryPpmBinary(width, height, maxValue);
    }

    @Override
    public InMemoryImage createBlank(int width, int height) {
        return new InMemoryPpmBinary(width, height);
    }
}
