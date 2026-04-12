package image.manipulators.compositors.collage;

import image.actions.collage.CollageDirection;
import image.images_in_memory.ppm.InMemoryPpm;
import image.signatures.FormatType;
import util.Color;

import java.util.List;

public class PpmCollager extends MaxValuedCollager<InMemoryPpm> {
    public PpmCollager(InMemoryPpm image1, InMemoryPpm image2, CollageDirection collageDirection) {
        super(image1, image2, collageDirection);
    }

    @Override
    protected InMemoryPpm getOutImage(int outWidth, int outHeight) {
        return null;
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

    @Override
    public List<FormatType> getSupportedFormats() {
        return List.of(
                FormatType.ASCII_PPM,
                FormatType.BINARY_PPM
        );
    }
}
