package image.actions;

import exceptions.ApplicationException;
import image.transformations.ImageTransformer;
import image.transformations.factory.MonochromerFactory;

public class MonochromeAction extends TransformationAction {
    public MonochromeAction(int imageCount, MonochromerFactory transformerFactory) {
        super(imageCount, transformerFactory);
    }

    @Override
    protected ImageTransformer<?> getTransformerInstance(Class<? extends ImageTransformer<?>> imageTransformer) {
        try {
            return imageTransformer.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate Monochromer", e);
        }
    }
}
