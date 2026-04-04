package image.images_in_memory.pgm;

import image.images_in_memory.InMemoryNetpbm;

public abstract class InMemoryPgm extends InMemoryNetpbm {
    private final short[][] pixels;

    public InMemoryPgm(int width, int height, short maxValue) {
        this.pixels = new short[width][height];
        super(width, height, maxValue);
    }

    public InMemoryPgm(int width, int height) {
        this.pixels = new short[width][height];
        super(width, height);
    }

    @Override
    public short getDefaultValue() {
        return 255;
    }

    public void setPixel(int h, int w, short val) {
        pixels[h][w] = val;
    }

    public short getPixel(int h, int w) {
        return pixels[h][w];
    }
}
