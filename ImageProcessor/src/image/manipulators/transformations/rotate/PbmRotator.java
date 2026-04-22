package image.manipulators.transformations.rotate;

import image.images_in_memory.netpbm.pbm.InMemoryPbm;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PBM, FormatType.BINARY_PBM})
public class PbmRotator extends AbstractRotator<InMemoryPbm> {
    public PbmRotator(byte cwSpins) {
        super(cwSpins);
    }

    @Override
    protected void setPixel(int rotI, int rotJ, InMemoryPbm rotated, int i, int j, InMemoryPbm original) {
        rotated.setPixel(rotI, rotJ, original.getPixel(i, j));
    }
}
