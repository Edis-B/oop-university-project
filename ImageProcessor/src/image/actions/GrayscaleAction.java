package image.actions;

import image.ImageContext;
import image.transformations.grayscaling.Grayscaler;
import image.transformations.grayscaling.factory.GrayscalerFactory;
import image.images_in_memory.InMemoryImage;
import session.ImageWrapper;

import java.util.List;

public class GrayscaleAction extends Action {
    private final GrayscalerFactory grayscalerFactory;

    public GrayscaleAction(int imageCount, GrayscalerFactory grayscalerFactory) {
        super(imageCount);
        this.grayscalerFactory = grayscalerFactory;
    }

    @Override
    public void execute(ImageContext imageContext) {
        List<ImageWrapper> imageWrappers = imageContext.getImageArray();
        for (int i = 0; i < imageCount; i++) {
            InMemoryImage currImage = imageWrappers.get(i).getImage();

            Class<? extends InMemoryImage> cl = currImage.getClass();
            Grayscaler<? extends InMemoryImage> grayscaler = grayscalerFactory.getGrayscaler(currImage.getFormat());

            applyGrayscale(grayscaler, imageWrappers.get(i));
        }
    }

    private <T extends InMemoryImage> void applyGrayscale(
            Grayscaler<T> grayscaler,
            ImageWrapper imageWrapper) {
        InMemoryImage currentImage = imageWrapper.getImage();

        @SuppressWarnings("unchecked")
        T specificImage = (T) imageWrapper.getImage();

        imageWrapper.setImage(grayscaler.transform(specificImage));
    }
}
