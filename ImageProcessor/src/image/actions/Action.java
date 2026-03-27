package image.actions;

import image.ImageContext;

public abstract class Action {
    private final int imageCount;

    public Action(int imageCount) {
        this.imageCount = imageCount;
    }

    public int getImageCount() {
        return imageCount;
    }

    public abstract void execute(ImageContext imageContext);
}
