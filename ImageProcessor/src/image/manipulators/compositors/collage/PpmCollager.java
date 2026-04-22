package image.manipulators.compositors.collage;

import image.actions.collage.CollageDirection;
import image.images_in_memory.netpbm.ppm.InMemoryPpm;
import image.manipulators.annotation.SupportedFormats;
import image.signatures.FormatType;
import util.Color;

@SupportedFormats({FormatType.ASCII_PPM, FormatType.BINARY_PPM})
public class PpmCollager extends MaxValuedCollager<InMemoryPpm> {
    public PpmCollager(InMemoryPpm image1, InMemoryPpm image2, CollageDirection collageDirection) {
        super(image1, image2, collageDirection);
    }

    @Override
    protected InMemoryPpm getBlankOutImage() {
        return (InMemoryPpm) image1.createBlank(outWidth, outHeight, outValue);
    }

    @Override
    protected void setPixel(int resI, int resJ, InMemoryPpm result, int i, int j, InMemoryPpm source) {
        Color resultPixel = source.getPixel(i, j);
        if (result.getMaxValue() != source.getMaxValue()) {
            short r = resultPixel.getRed(),
                    g = resultPixel.getGreen(),
                    b = resultPixel.getBlue();

            resultPixel = new Color(
                    (short) (r * getCoefficient()),
                    (short) (g * getCoefficient()),
                    (short) (b * getCoefficient())
            );
        }

        result.setPixel(resI, resJ, resultPixel);
    }
}
