package image.actions;

import image.transformations.factory.negating.NegatorFactory;

public class NegativeAction extends Action {

    public NegativeAction(int imageCount, NegatorFactory transformerFactory) {
        super(imageCount, transformerFactory);
    }
}
