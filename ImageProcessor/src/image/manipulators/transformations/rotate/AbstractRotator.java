package image.manipulators.transformations.rotate;

import image.images_in_memory.InMemoryImage;
import image.images_in_memory.netpbm.ppm.InMemoryPpm;

public abstract class AbstractRotator<T extends InMemoryImage> implements Rotator<T> {
    private final byte cwSpins;

    public AbstractRotator(byte cwSpins) {
        this.cwSpins = cwSpins;
    }

    @Override
    public InMemoryImage transform(T original) {
        int origHeight = original.getHeight(),
                origWidth = original.getWidth();

        int width = cwSpins == 2 ? origWidth : origHeight,
                height = cwSpins == 2 ? origHeight : origWidth;

        @SuppressWarnings("unchecked")
        T result = (T) original.createBlank(width, height);

        for (int i = 0; i < origHeight; i++) {
            for (int j = 0; j < origWidth; j++) {
                int rotI, rotJ;

                switch (cwSpins) {
                    case 1:
                        rotI = j;
                        rotJ = (origHeight - 1) - i;
                        break;
                    case 2:
                        rotI = (origHeight - 1) - i;
                        rotJ = (origWidth - 1) - j;
                        break;
                    case 3:
                        rotI = (origWidth - 1) - j;
                        rotJ = i;
                        break;
                    default:
                        rotI = i;
                        rotJ = j;
                        break;
                }

                setPixel(rotI, rotJ, result, i, j, original);
            }
        }

        return result;
    }

    protected abstract void setPixel(int rotI, int rotJ, T rotated, int i, int j, T original);
}
