package image.images_in_memory.pbm;

import image.images_in_memory.InMemoryNetpbm;

public abstract class InMemoryPbm extends InMemoryNetpbm {
    private final boolean[][] pixels;

    public InMemoryPbm(int width, int height) {
        pixels = new boolean[width][height];
        super(width, height);
    }

    public InMemoryPbm(int width, int height, short maxValue) {
        pixels = new boolean[width][height];
        super(width, height, maxValue);
    }

    public void setPixel(int h, int w, boolean val) {
        pixels[h][w] = val;
    }

    public boolean getPixel(int h, int w) {
        return pixels[h][w];
    }

    @Override
    public short getDefaultValue() {
        return 1;
    }
}
