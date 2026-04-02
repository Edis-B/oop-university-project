package image.actions;

import image.ImageContext;
import session.ImageWrapper;

import java.util.List;

public abstract class Action {
    protected final int imageCount;

    public Action(int imageCount) {
        this.imageCount = imageCount;
    }

    public int getImageCount() {
        return imageCount;
    }

    public abstract void execute(ImageContext imageContext);
}
