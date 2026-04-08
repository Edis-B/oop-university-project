package image.actions;

import image.ImageContext;
import image.images_in_memory.InMemoryImage;
import image.transformations.negating.Negator;
import image.transformations.negating.factory.NegatorFactory;
import session.ImageWrapper;

import java.util.List;

public class NegativeAction extends Action {
    private final NegatorFactory negatorFactory;

    public NegativeAction(int imageCount, NegatorFactory negatorFactory) {
        super(imageCount);
        this.negatorFactory = negatorFactory;
    }

    @Override
    public void execute(ImageContext imageContext) {
        List<ImageWrapper> imageWrappers = imageContext.getImageArray();
        for (int i = 0; i < imageWrappers.size(); i++) {
            InMemoryImage currImage = imageWrappers.get(i).getImage();

            Negator<? extends InMemoryImage> negator = negatorFactory.getNegator(currImage.getFormat());


        }
    }


}
