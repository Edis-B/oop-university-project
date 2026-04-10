package image.images_in_memory.ppm;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.InMemoryMaxValuable;
import util.Color;

public abstract class InMemoryPpm extends InMemoryMaxValuable {
    private final Color[][] pixels;

    public InMemoryPpm(int width, int height, short maxValue) {
        this.pixels = new Color[width][height];
        super(width, height, maxValue);
    }

    public InMemoryPpm(int width, int height) {
        this.pixels = new Color[width][height];
        super(width, height);
    }

    public void setPixel(int h, int w, Color val) {
        pixels[h][w] = val;
    }

    public Color getPixel(int h, int w) {
        return pixels[h][w];
    }

    @Override
    public short getDefaultValue() {
        return 255;
    }
}
