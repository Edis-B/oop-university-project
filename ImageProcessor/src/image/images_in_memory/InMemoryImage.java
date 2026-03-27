package image.images_in_memory;

import image.signatures.FormatType;

public abstract class InMemoryImage {
    protected final int width;
    protected final int height;

    public InMemoryImage(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract FormatType getFormat();
}
