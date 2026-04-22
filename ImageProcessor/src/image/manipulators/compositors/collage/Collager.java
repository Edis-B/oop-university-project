package image.manipulators.compositors.collage;

import image.actions.collage.CollageDirection;
import image.manipulators.compositors.ImageCompositor;
import image.images_in_memory.InMemoryImage;
import session.ImageContext;

public abstract class Collager<T extends InMemoryImage> implements ImageCompositor<T> {
    protected final T image1;
    protected final T image2;
    protected final CollageDirection collageDirection;

    protected Integer outWidth, outHeight;

    public Collager(T image1, T image2, CollageDirection collageDirection) {
        this.image1 = image1;
        this.image2 = image2;
        this.collageDirection = collageDirection;

        outWidth = collageDirection == CollageDirection.HORIZONTAL ?
                image1.getWidth() + image2.getWidth() : image1.getWidth();

        outHeight = collageDirection == CollageDirection.VERTICAL ?
                image1.getHeight() + image2.getHeight() : image1.getHeight();
    }

    public InMemoryImage execute(ImageContext imageContext) {
        int image1Width = image1.getWidth(),
                image1Height = image1.getHeight(),
                image2Width = image2.getWidth(),
                image2Height = image2.getHeight();

        int[][] start = {
                {0, image1Width}, {image1Height, 0}
        };

        T outImage = getBlankOutImage();

        for (int i = 0; i < image1Height; i++) {
            for (int j = 0; j < image1Width; j++) {
                setPixel(i, j, outImage, i, j, image1);
            }
        }

        int startRow = start[collageDirection.getValue()][0],
                startCol = start[collageDirection.getValue()][1];

        for (int i = 0; i < image2Height; i++) {
            for (int j = 0; j < image2Width; j++) {
                setPixel(i + startRow, j + startCol, outImage, i, j, image2);
            }
        }

        return outImage;
    }

    protected abstract T getBlankOutImage();

    protected abstract void setPixel(int resI, int resJ, T result, int i, int j, T source);
}
