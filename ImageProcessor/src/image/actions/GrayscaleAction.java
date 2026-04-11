package image.actions;

import exceptions.ApplicationException;
import image.transformations.ImageTransformer;
import image.transformations.factory.GrayscalerFactory;

public class GrayscaleAction extends TransformationAction {
    public GrayscaleAction(int imageCount, GrayscalerFactory transformerFactory) {
        super(imageCount, transformerFactory);
    }

    @Override
    protected ImageTransformer<?> getTransformerInstance(Class<? extends ImageTransformer<?>> imageTransformer) {
        try {
            return imageTransformer.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate Grayscaler");
        }
    }
}
