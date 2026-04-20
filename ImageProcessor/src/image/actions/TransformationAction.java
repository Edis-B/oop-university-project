package image.actions;

import exceptions.ApplicationException;
import session.ImageContext;
import image.images_in_memory.InMemoryImage;
import image.manipulators.transformations.ImageTransformer;
import image.manipulators.transformations.factory.TransformerFactory;
import session.ImageWrapper;

import java.util.List;

public abstract class TransformationAction extends AbstractAction {
    protected final int imageCount;
    protected final TransformerFactory<? extends ImageTransformer<?>> transformerFactory;

    public TransformationAction(int imageCount,
                                TransformerFactory<?> transformerFactory,
                                String commandString) {
        super(commandString);
        this.imageCount = imageCount;
        this.transformerFactory = transformerFactory;
    }

    public int getImageCount() {
        return imageCount;
    }

    @Override
    public void execute(ImageContext imageContext) {
        List<ImageWrapper> imageWrappers = imageContext.getImageWrapperArray();
        for (int i = 0; i < imageCount; i++) {
            InMemoryImage currImage = imageWrappers.get(i).getImage();

            Class<? extends ImageTransformer<?>> transformerClass =
                    transformerFactory.search(currImage.getFormat());

            // Transformation not viable for image
            if (transformerClass == null) continue;

            ImageTransformer<?> imageTransformer = getTransformerInstance(transformerClass);

            applyTransformation(imageTransformer, imageWrappers.get(i));
        }
    }

    protected abstract ImageTransformer<?> getTransformerInstance(Class<? extends ImageTransformer<?>> imageTransformer);

    private <T extends InMemoryImage> void applyTransformation(
            ImageTransformer<T> imageTransformer,
            ImageWrapper imageWrapper) {
        @SuppressWarnings("unchecked")
        T specificImage = (T) imageWrapper.getImage();

        imageWrapper.setImage(imageTransformer.transform(specificImage));
    }
}
