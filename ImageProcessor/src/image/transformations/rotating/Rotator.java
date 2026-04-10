package image.transformations.rotating;

import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import image.transformations.ImageTransformer;

import java.util.List;

public class Rotator<T extends InMemoryImage> implements ImageTransformer<T> {
    private final byte cwSpins;

    public Rotator(byte cwSpins) {
        this.cwSpins = cwSpins;
    }

    @Override
    public InMemoryImage transform(T original) {
        int width = cwSpins == 2 ? original.getWidth() : original.getHeight(),
                height = cwSpins == 2 ? original.getHeight() : original.getWidth();

        //        original.getClass().getDeclaredMethods().
//        InMemoryImage rotated = original.createBlank(original.);

        return null;
    }

    @Override
    public List<FormatType> getSupportedFormats() {
        return List.of();
    }
}
