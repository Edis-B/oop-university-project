package image.images_in_memory.pbm;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

public class InMemoryPbmBinary extends InMemoryPbm {
    public InMemoryPbmBinary(int width, int height) {
        super(width, height);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.BINARY_PBM;
    }

    @Override
    public InMemoryPbmBinary createBlank(int width, int height) {
        return new InMemoryPbmBinary(width, height);
    }
}
