package image.images_in_memory.netpbm.ppm;

import image.signatures.FormatType;

public class InMemoryPpmAscii extends InMemoryPpm {
    public InMemoryPpmAscii(int width, int height, short maxValue) {
        super(width, height, maxValue);
    }

    public InMemoryPpmAscii(int width, int height) {
        super(width, height);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.ASCII_PPM;
    }

    @Override
    public InMemoryPpmAscii createBlank(int width, int height, short maxValue) {
        return new InMemoryPpmAscii(width, height, maxValue);
    }

    @Override
    public InMemoryPpmAscii createBlank(int width, int height) {
        return new InMemoryPpmAscii(width, height);
    }
}

