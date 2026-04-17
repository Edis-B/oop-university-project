package image.images_in_memory.netpbm.pgm;

import image.images_in_memory.netpbm.InMemoryMaxValuable;

public abstract class InMemoryPgm extends InMemoryMaxValuable {
    private final short[][] pixels;

    public InMemoryPgm(int width, int height, short maxValue) {
        this.pixels = new short[height][width];
        super(width, height, maxValue);
    }

    public InMemoryPgm(int width, int height) {
        this.pixels = new short[height][width];
        super(width, height);
    }

    public void setPixel(int h, int w, short val) {
        pixels[h][w] = val;
    }

    public short getPixel(int h, int w) {
        return pixels[h][w];
    }

    @Override
    public short getDefaultValue() {
        return 255;
    }
}
