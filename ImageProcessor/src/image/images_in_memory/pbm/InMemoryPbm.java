package image.images_in_memory.pbm;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.InMemoryMaxValuable;

public abstract class InMemoryPbm extends InMemoryImage {
    private final boolean[][] pixels;

    public InMemoryPbm(int width, int height) {
        pixels = new boolean[width][height];
        super(width, height);
    }

    public void setPixel(int h, int w, boolean val) {
        pixels[h][w] = val;
    }

    public boolean getPixel(int h, int w) {
        return pixels[h][w];
    }

}
