package image.images_in_memory.ppm;

import image.images_in_memory.InMemoryImage;
import util.Color;

public abstract class InMemoryPpm extends InMemoryImage {
    private final int maxValue;
    private final Color[][] pixels;

    public InMemoryPpm(int width, int height, int maxValue) {
        super(width, height);
        this.maxValue = maxValue;
        this.pixels = new Color[width][height];
    }

    public void setPixel(int i, int j, Color val) {
        pixels[i][j] = val;
    }

    public Color getPixel(int i, int j) {
        return pixels[i][j];
    }
}
