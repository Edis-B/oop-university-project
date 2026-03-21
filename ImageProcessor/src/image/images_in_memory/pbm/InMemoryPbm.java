package image.images_in_memory.pbm;

import image.images_in_memory.InMemoryImage;

public abstract class InMemoryPbm extends InMemoryImage {
    private final boolean[][] pixels;

    public InMemoryPbm(int width, int height) {
        super(width, height);
        pixels = new boolean[width][height];
    }

    public void setPixel(int i, int j, boolean val) {
        pixels[i][j] = val;
    }

    public boolean getPixel(int i, int j) {
        return pixels[i][j];
    }
}
