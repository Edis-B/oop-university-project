package image.images_in_memory.ppm;

import image.images_in_memory.InMemoryImage;

public abstract class InMemoryPpm  extends InMemoryImage {
    private int maxValue;

    short[][][] pixels;
}
