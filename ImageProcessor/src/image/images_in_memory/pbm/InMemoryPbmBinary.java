package image.images_in_memory.pbm;

import image.signatures.FormatType;

public class InMemoryPbmBinary extends InMemoryPbm {
    public InMemoryPbmBinary(int width, int height) {
        super(width, height);
    }

    public InMemoryPbmBinary(int width, int height, int maxValue) {
        super(width, height, maxValue);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.BINARY_PBM;
    }
}
