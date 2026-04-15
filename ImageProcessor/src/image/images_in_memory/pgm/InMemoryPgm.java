package image.images_in_memory.pgm;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.InMemoryMaxValuable;

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
