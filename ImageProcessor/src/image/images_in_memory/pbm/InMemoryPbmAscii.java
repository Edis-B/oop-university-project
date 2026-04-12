package image.images_in_memory.pbm;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

public class InMemoryPbmAscii extends InMemoryPbm {
    public InMemoryPbmAscii(int width, int height) {
        super(width, height);
    }

    @Override
    public FormatType getFormat() {
        return FormatType.ASCII_PBM;
    }

    @Override
    public InMemoryPbmAscii createBlank(int width, int height) {
        return new InMemoryPbmAscii(width, height);
    }
}
