package image.compositors.collage;

import image.compositors.ImageCompositor;
import image.images_in_memory.InMemoryImage;
import session.ImageContext;

public abstract class Collager<T extends InMemoryImage> implements ImageCompositor<T> {
    private final T image1, image2;

    public Collager(T image1, T image2) {
        this.image1 = image1;
        this.image2 = image2;
    }

    public void execute(ImageContext imageContext) {
        imageContext.getImageWrapperArray();
    }
}
