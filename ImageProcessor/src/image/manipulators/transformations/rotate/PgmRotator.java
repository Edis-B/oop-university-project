package image.manipulators.transformations.rotate;

import image.images_in_memory.pgm.InMemoryPgm;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PGM, FormatType.BINARY_PGM})
public class PgmRotator extends AbstractRotator<InMemoryPgm> {
    public PgmRotator(byte cwSpins) {
        super(cwSpins);
    }

    @Override
    protected void setPixel(int i, int j, InMemoryPgm rotated, int rotI, int rotJ, InMemoryPgm original) {
        rotated.setPixel(i, j, original.getPixel(rotI, rotJ));
    }
}
