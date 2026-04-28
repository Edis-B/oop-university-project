package image.actions;

import exceptions.ApplicationException;
import image.manipulators.transformations.ImageTransformer;
import image.manipulators.transformations.factory.NegatorFactory;

public class NegativeAction extends TransformationAction {

    public NegativeAction(NegatorFactory transformerFactory, String commandString) {
        super(transformerFactory, commandString);
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
