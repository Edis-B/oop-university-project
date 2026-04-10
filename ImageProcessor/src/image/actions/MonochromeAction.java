package image.actions;

import exceptions.ApplicationException;
import image.transformations.ImageTransformer;
import image.transformations.factory.MonochromerFactory;

import java.lang.reflect.InvocationTargetException;

public class MonochromeAction extends Action {
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
