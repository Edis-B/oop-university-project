package image.images_in_memory.pgm;

import image.images_in_memory.InMemoryImage;
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

    @Override
    public InMemoryImage createBlank(int width, int height, short maxValue) {
        return new InMemoryPgmBinary(width, height, maxValue);
    }

    @Override
    public InMemoryImage createBlank(int width, int height) {
        return new InMemoryPgmBinary(width, height);
    }
}
