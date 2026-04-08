package image.actions;

import image.ImageContext;
import image.transformations.factory.TransformerFactory;
import image.transformations.grayscaling.Grayscaler;
import image.transformations.factory.grayscaling.GrayscalerFactory;
import image.images_in_memory.InMemoryImage;
import session.ImageWrapper;

import java.util.List;

public class GrayscaleAction extends Action {
    public GrayscaleAction(int imageCount, GrayscalerFactory transformerFactory) {
        super(imageCount, transformerFactory);
    }
}
