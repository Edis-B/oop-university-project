package image.images_in_memory.netpbm.ppm;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.InMemoryMaxValued;
import image.images_in_memory.netpbm.pgm.InMemoryPgm;
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

    @Override
    public InMemoryImage copy() {
        InMemoryPpm newImage = (InMemoryPpm) createBlank(width, height, maxValue);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                var oldPixel = getPixel(i, j);

                newImage.setPixel(i, j, new Color(oldPixel.getRed(),
                        oldPixel.getGreen(),
                        oldPixel.getBlue()
                ));
            }
        }

        return newImage;
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
