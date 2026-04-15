package image.manipulators.compositors.collage;

import image.actions.collage.CollageDirection;
import image.images_in_memory.pgm.InMemoryPgm;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PGM, FormatType.BINARY_PGM})
public class PgmCollager extends MaxValuedCollager<InMemoryPgm> {
    public PgmCollager(InMemoryPgm image1, InMemoryPgm image2, CollageDirection collageDirection) {
        super(image1, image2, collageDirection);
    }

    @Override
    protected InMemoryPgm getOutImage() {
        return (InMemoryPgm) image1.createBlank(outWidth, outHeight, outValue);
    }

    @Override
    protected void setPixel(int resI, int resJ, InMemoryPgm result, int i, int j, InMemoryPgm source) {
        short resultPixel = source.getPixel(i, j);
        if (result.getMaxValue() != source.getMaxValue()) {
            resultPixel = (short) (resultPixel * getCoefficient());
        }

        result.setPixel(resI, resJ, resultPixel);
    }
}
