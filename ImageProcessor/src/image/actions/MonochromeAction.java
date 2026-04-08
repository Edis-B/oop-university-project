package image.actions;

import image.transformations.factory.monochroming.MonochromerFactory;

public class MonochromeAction extends Action {
    public MonochromeAction(int imageCount, MonochromerFactory transformerFactory) {
        super(imageCount, transformerFactory);
    }
}
