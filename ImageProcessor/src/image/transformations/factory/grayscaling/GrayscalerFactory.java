package image.transformations.factory.grayscaling;

import image.transformations.factory.AbstractTransformerFactory;

public class GrayscalerFactory extends AbstractTransformerFactory {
    private GrayscalerFactory() { }

    private static GrayscalerFactory instance;
    public static GrayscalerFactory getInstance() {
        if (instance == null)
            instance = new GrayscalerFactory();

        return instance;
    }
}
