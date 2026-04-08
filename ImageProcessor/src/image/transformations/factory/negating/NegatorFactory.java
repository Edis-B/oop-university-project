package image.transformations.factory.negating;

import image.transformations.factory.AbstractTransformerFactory;

public class NegatorFactory extends AbstractTransformerFactory {
    private NegatorFactory() {
    }

    private static NegatorFactory instance;
    public static NegatorFactory getInstance() {
        if (instance == null)
            instance = new NegatorFactory();

        return instance;
    }
}
