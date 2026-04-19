package image.images_in_memory.netpbm.pgm;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.InMemoryMaxValued;

public abstract class InMemoryPgm extends InMemoryMaxValued {
    private final short[][] pixels;

    public InMemoryPgm(int width, int height, short maxValue) {
        this.pixels = new short[height][width];
        super(width, height, maxValue);
    }

    public InMemoryPgm(int width, int height) {
        this.pixels = new short[height][width];
        super(width, height);
    }

    @Override
    public InMemoryImage copy() {
        InMemoryPgm newImage = (InMemoryPgm) createBlank(width, height, maxValue);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newImage.setPixel(i, j, getPixel(i, j));
            }
        }

        return newImage;
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
