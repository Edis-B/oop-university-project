package image.images_in_memory.pgm;

import image.images_in_memory.InMemoryImage;

public abstract class InMemoryPgm extends InMemoryImage {
    private int maxValue;

    short[][] pixels;
}
