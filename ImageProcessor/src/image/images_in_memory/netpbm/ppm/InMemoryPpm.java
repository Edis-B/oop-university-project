package image.images_in_memory.netpbm.ppm;

import image.images_in_memory.netpbm.InMemoryMaxValued;
import util.Color;

public abstract class InMemoryPpm extends InMemoryMaxValued {
    private final Color[][] pixels;

    public InMemoryPpm(int width, int height, short maxValue) {
        this.pixels = new Color[height][width];
        super(width, height, maxValue);
    }

    public InMemoryPpm(int width, int height) {
        this.pixels = new Color[height][width];
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
