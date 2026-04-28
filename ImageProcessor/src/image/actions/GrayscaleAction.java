package image.actions;

import exceptions.ApplicationException;
import image.manipulators.transformations.ImageTransformer;
import image.manipulators.transformations.factory.GrayscalerFactory;

public class GrayscaleAction extends TransformationAction {
    public GrayscaleAction(GrayscalerFactory transformerFactory,
                           String commandString) {
        super(transformerFactory, commandString);
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
