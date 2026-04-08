package image.actions;

import image.ImageContext;
import image.images_in_memory.InMemoryImage;
import image.transformations.monochroming.Monochromer;
import image.transformations.monochroming.factory.MonochromerFactory;
import session.ImageWrapper;

import java.util.List;

public class MonochromeAction extends Action {
    private final MonochromerFactory monochromerFactory;

    public MonochromeAction(int imageCount, MonochromerFactory monochromerFactory) {
        super(imageCount);
        this.monochromerFactory = monochromerFactory;
    }

    @Override
    public void execute(ImageContext imageContext) {
        List<ImageWrapper> imageWrappers = imageContext.getImageArray();
        for (int i = 0; i < imageCount; i++) {
            InMemoryImage currImage = imageWrappers.get(i).getImage();

            Monochromer<? extends InMemoryImage> monochromer = monochromerFactory.getMonochromer(currImage.getFormat());

            if (monochromer == null)
                continue;

            applyMonochrome(monochromer, imageWrappers.get(i));
        }
    }

    private <T extends InMemoryImage> void applyMonochrome(
            Monochromer<T> monochromer,
            ImageWrapper imageWrapper) {
        @SuppressWarnings("unchecked")
        T castedImage = (T) imageWrapper.getImage();

        imageWrapper.setImage(monochromer.transform(castedImage));
    }
}
