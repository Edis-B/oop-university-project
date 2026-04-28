package image.actions.rotate;

import exceptions.ApplicationException;
import image.actions.TransformationAction;
import image.manipulators.transformations.ImageTransformer;
import image.manipulators.transformations.factory.RotatorFactory;

public class RotateAction extends TransformationAction {
    private final RotateDirection direction;

    public RotateAction(RotateDirection direction, RotatorFactory rotatorFactory, String commandString) {
        super(rotatorFactory, commandString);
        this.direction = direction;
    }

    @Override
    protected ImageTransformer<?> getTransformerInstance(Class<? extends ImageTransformer<?>> imageTransformer) {
        try {
            return imageTransformer.getConstructor(byte.class).newInstance(direction.cwSpins);
        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate Rotator!", e);
        }
    }
}
