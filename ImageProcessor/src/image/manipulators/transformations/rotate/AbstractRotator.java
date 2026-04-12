package image.manipulators.transformations.rotate;

import image.images_in_memory.InMemoryImage;

public abstract class AbstractRotator<T extends InMemoryImage> implements Rotator<T> {
    private final byte cwSpins;

    public AbstractRotator(byte cwSpins) {
        this.cwSpins = cwSpins;
    }

    private final int[][] diff = {
            {1, 1}, {-1, 1}, {-1, -1}, {1, -1}
    };

    @Override
    public InMemoryImage transform(T original) {
        int origHeight = original.getHeight(),
                origWidth = original.getWidth();

        int width = cwSpins == 2 ? origWidth : origHeight,
                height = cwSpins == 2 ? origHeight : origWidth;

        @SuppressWarnings("unchecked")
        T result = (T) original.createBlank(width, height);

        int[][] start = {
                {0, 0}, {0, origWidth - 1}, {origWidth - 1, origHeight - 1}, {0, origHeight - 1}
        };

        int startRow = start[cwSpins][0], startCol = start[cwSpins][1];
        for (int i = 0; i < origHeight; i++) {
            for (int j = 0; j < origWidth; j++) {
                int rotI = startRow + (diff[cwSpins][0] * i),
                        rotJ = startCol + (diff[cwSpins][1] * j);

                setPixel(i, j, result, rotI, rotJ, original);
            }
        }

        return result;
    }

    protected abstract void setPixel(int i, int j, T rotated, int rotI, int rotJ, T original);
}
