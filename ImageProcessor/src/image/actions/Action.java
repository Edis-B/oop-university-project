package image.actions;

import image.ImageContext;
import image.images_in_memory.InMemoryImage;
import image.transformations.ImageTransformer;
import image.transformations.factory.TransformerFactory;
import image.transformations.grayscaling.Grayscaler;
import session.ImageWrapper;

import java.util.List;

public abstract class Action {
    protected final int imageCount;
    protected final TransformerFactory transformerFactory;

    public Action(int imageCount, TransformerFactory transformerFactory) {
        this.imageCount = imageCount;
        this.transformerFactory = transformerFactory;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void execute(ImageContext imageContext) {
        List<ImageWrapper> imageWrappers = imageContext.getImageArray();
        for (int i = 0; i < imageCount; i++) {
            InMemoryImage currImage = imageWrappers.get(i).getImage();

            Class<? extends InMemoryImage> clazz = currImage.getClass();

            ImageTransformer<? extends InMemoryImage> imageTransformer =
                    transformerFactory.getTransformer(currImage.getFormat());

            applyTransformation(imageTransformer, imageWrappers.get(i));
        }
    }

    private <T extends InMemoryImage> void applyTransformation(
            ImageTransformer<T> imageTransformer,
            ImageWrapper imageWrapper) {
        @SuppressWarnings("unchecked")
        T specificImage = (T) imageWrapper.getImage();

        imageWrapper.setImage(imageTransformer.transform(specificImage));
    }
}
