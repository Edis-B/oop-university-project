package image.manipulators.compositors.collage;

import image.actions.collage.CollageDirection;
import image.images_in_memory.netpbm.pbm.InMemoryPbm;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PBM, FormatType.BINARY_PBM})
public class PbmCollager extends Collager<InMemoryPbm> {
    public PbmCollager(InMemoryPbm image1, InMemoryPbm image2, CollageDirection collageDirection) {
        super(image1, image2, collageDirection);
    }

    @Override
    protected InMemoryPbm getBlankOutImage() {
        return (InMemoryPbm) image1.createBlank(outWidth, outHeight);
    }

    @Override
    protected void setPixel(int resI, int resJ, InMemoryPbm result, int i, int j, InMemoryPbm source) {
        result.setPixel(resI, resJ, source.getPixel(i, j));
    }
}
