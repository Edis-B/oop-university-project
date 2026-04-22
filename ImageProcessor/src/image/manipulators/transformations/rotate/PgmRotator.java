package image.manipulators.transformations.rotate;

import image.images_in_memory.netpbm.pgm.InMemoryPgm;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PGM, FormatType.BINARY_PGM})
public class PgmRotator extends AbstractRotator<InMemoryPgm> {
    public PgmRotator(byte cwSpins) {
        super(cwSpins);
    }

    @Override
    protected void setPixel(int rotI, int rotJ, InMemoryPgm rotated, int i, int j, InMemoryPgm original) {
        rotated.setPixel(rotI, rotJ, original.getPixel(i, j));
    }
}
