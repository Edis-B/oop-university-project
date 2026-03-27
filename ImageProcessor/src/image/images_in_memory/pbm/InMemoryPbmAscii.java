package image.images_in_memory.pbm;

import image.signatures.FormatType;

public class InMemoryPbmAscii extends InMemoryPbm {
    public InMemoryPbmAscii(int width, int height) {
        super(width, height);
    }

    public InMemoryPbmAscii(int width, int height, int maxValue) {
        super(width, height, maxValue);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.ASCII_PBM;
    }
}
