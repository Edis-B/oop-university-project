package image.actions;

import exceptions.ApplicationException;
import image.manipulators.transformations.ImageTransformer;
import image.manipulators.transformations.factory.MonochromerFactory;

public class MonochromeAction extends TransformationAction {
    public MonochromeAction(MonochromerFactory transformerFactory, String commandString) {
        super(transformerFactory, commandString);
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
