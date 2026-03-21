package image.images_in_memory.pgm;

import image.images_in_memory.InMemoryImage;

public abstract class InMemoryPgm extends InMemoryImage {
    private final int maxValue;
    private final short[][] pixels;

    public InMemoryPgm(int width, int height, int maxValue) {
        super(width, height);
        this.maxValue = maxValue;
        this.pixels = new short[width][height];
    }

    public void setPixel(int i, int j, short val) {
        pixels[i][j] = val;
    }

    public short getPixel(int i, int j) {
        return pixels[i][j];
    }
}
