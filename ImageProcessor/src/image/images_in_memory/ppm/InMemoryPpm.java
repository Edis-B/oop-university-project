package image.images_in_memory.ppm;

import image.images_in_memory.InMemoryNetpbm;
import image.images_in_memory.RgbImage;
import util.Color;

public abstract class InMemoryPpm extends InMemoryNetpbm implements RgbImage {
    private final Color[][] pixels;

    public InMemoryPpm(int width, int height, int maxValue) {
        this.pixels = new Color[width][height];
        super(width, height);
    }

    public InMemoryPpm(int width, int height) {
        this.pixels = new Color[width][height];
        super(width, height);
    }

    @Override
    public int getDefaultValue() {
        return 255;
    }

    public void setPixel(int h, int w, Color val) {
        pixels[h][w] = val;
    }

    public Color getPixel(int h, int w) {
        return pixels[h][w];
    }
}
