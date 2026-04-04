package image.images_in_memory.pgm;

import image.signatures.FormatType;

public class InMemoryPgmBinary extends InMemoryPgm {
    public InMemoryPgmBinary(int width, int height, short maxValue) {
        super(width, height, maxValue);
    }

    public InMemoryPgmBinary(int width, int height) {
        super(width, height);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.BINARY_PGM;
    }
}
