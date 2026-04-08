package image.transformations.factory.monochroming;

import image.transformations.factory.AbstractTransformerFactory;

public class MonochromerFactory extends AbstractTransformerFactory {
    private MonochromerFactory() {
    }

    private static MonochromerFactory instance;
    public static MonochromerFactory getInstance() {
        if (instance == null)
            instance = new MonochromerFactory();

        return instance;
    }
}
