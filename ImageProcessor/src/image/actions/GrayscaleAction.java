package image.actions;

import image.ImageContext;
import session.ImageWrapper;

import java.util.List;

public class GrayscaleAction extends Action {
    public GrayscaleAction(int imageCount) {
        super(imageCount);
    }

    @Override
    public void execute(ImageContext imageContext) {
        List<ImageWrapper> imageWrappers = imageContext.getImageArray();
        for (int i = 0; i < imageCount; i++) {
            var currImage = imageWrappers.get(i).getImage();


        }
    }
}
