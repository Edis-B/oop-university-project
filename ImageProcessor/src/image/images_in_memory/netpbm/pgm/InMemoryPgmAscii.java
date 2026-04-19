package image.images_in_memory.netpbm.pgm;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

public class InMemoryPgmAscii extends InMemoryPgm {
    public InMemoryPgmAscii(int width, int height, short maxValue) {
        super(width, height, maxValue);
    }

    public InMemoryPgmAscii(int width, int height) {
        super(width, height);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.ASCII_PGM;
    }

    @Override
    public InMemoryPgmAscii createBlank(int width, int height, short maxValue) {
        return new InMemoryPgmAscii(width, height, maxValue);
    }

    @Override
    public InMemoryPgmAscii createBlank(int width, int height) {
        return new InMemoryPgmAscii(width, height);
    }
}
