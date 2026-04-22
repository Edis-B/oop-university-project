package image.manipulators.transformations.rotate;

import image.images_in_memory.netpbm.ppm.InMemoryPpm;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PPM, FormatType.BINARY_PPM})
public class PpmRotator extends AbstractRotator<InMemoryPpm> {
    public PpmRotator(byte cwSpins) {
        super(cwSpins);
    }

    @Override
    protected void setPixel(int rotI, int rotJ, InMemoryPpm rotated, int i, int j, InMemoryPpm original) {
        rotated.setPixel(rotI, rotJ, original.getPixel(i, j));
    }
}
