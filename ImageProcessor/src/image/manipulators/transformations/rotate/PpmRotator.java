package image.manipulators.transformations.rotate;

import image.images_in_memory.ppm.InMemoryPpm;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;

@SupportedFormats({FormatType.ASCII_PPM, FormatType.BINARY_PPM})
public class PpmRotator extends AbstractRotator<InMemoryPpm> {
    public PpmRotator(byte cwSpins) {
        super(cwSpins);
    }

    @Override
    protected void setPixel(int i, int j, InMemoryPpm rotated, int rotI, int rotJ, InMemoryPpm original) {
        rotated.setPixel(i, j, original.getPixel(rotI, rotJ));
    }
}
