package image.images_in_memory.netpbm.pbm;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.InMemoryNetpbm;

public abstract class InMemoryPbm extends InMemoryNetpbm {
    private final boolean[][] pixels;

    public InMemoryPbm(int width, int height) {
        pixels = new boolean[height][width];
        super(width, height);
    }

    @Override
    public InMemoryImage copy() {
        InMemoryPbm newImage = (InMemoryPbm) createBlank(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newImage.setPixel(i, j, getPixel(i, j));
            }
        }

        return newImage;
    }

    public void setPixel(int h, int w, boolean val) {
        pixels[h][w] = val;
    }

    public boolean getPixel(int h, int w) {
        return pixels[h][w];
    }
}
