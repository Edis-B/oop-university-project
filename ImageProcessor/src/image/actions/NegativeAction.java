package image.actions;

import exceptions.ApplicationException;
import image.transformations.ImageTransformer;
import image.transformations.factory.NegatorFactory;

import java.lang.reflect.InvocationTargetException;

public class NegativeAction extends Action {

    public NegativeAction(int imageCount, NegatorFactory transformerFactory) {
        super(imageCount, transformerFactory);
    }

    @Override
    protected ImageTransformer<?> getTransformerInstance(Class<? extends ImageTransformer<?>> imageTransformer) {
        try {
            return imageTransformer.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate Negator!", e);
        }
    }
}
