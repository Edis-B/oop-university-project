package image.manipulators.compositors.collage;

import image.actions.collage.CollageDirection;
import image.images_in_memory.pbm.InMemoryPbm;
import image.signatures.FormatType;

import java.util.List;

public class PbmCollager extends Collager<InMemoryPbm> {
    public PbmCollager(InMemoryPbm image1, InMemoryPbm image2, CollageDirection collageDirection) {
        super(image1, image2, collageDirection);
    }

    @Override
    protected InMemoryPbm getOutImage(int outWidth, int outHeight) {
        return (InMemoryPbm) image1.createBlank(outWidth, outHeight);
    }

    @Override
    protected void setPixel(int resI, int resJ, InMemoryPbm result, int i, int j, InMemoryPbm source) {
        result.setPixel(resI, resJ, source.getPixel(i, j));
    }

    @Override
    public List<FormatType> getSupportedFormats() {
        return List.of(
                FormatType.ASCII_PBM,
                FormatType.BINARY_PBM
        );
    }
}
