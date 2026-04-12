package image.manipulators.compositors.collage;

import image.actions.collage.CollageDirection;
import image.manipulators.compositors.ImageCompositor;
import image.images_in_memory.InMemoryImage;
import session.ImageContext;

public abstract class Collager<T extends InMemoryImage> implements ImageCompositor<T> {
    protected final T image1;
    protected final T image2;
    protected final CollageDirection collageDirection;

    public Collager(T image1, T image2, CollageDirection collageDirection) {
        this.image1 = image1;
        this.image2 = image2;
        this.collageDirection = collageDirection;
    }

    public void execute(ImageContext imageContext) {
        int image1Width = image1.getWidth(),
                image1Height = image1.getHeight(),
                image2Width = image2.getWidth(),
                image2Height = image2.getHeight();

        int outWidth = collageDirection == CollageDirection.HORIZONAL ?
                image1Width + image2Width : image1Width;

        int outHeight = collageDirection == CollageDirection.VERTICAL ?
                image1Height + image2Height : image1Height;

        int[][] start = {
                {0, image1Width}, {image1Height, 0}
        };

        T outImage = getOutImage(outWidth, outHeight);

        for (int i = 0; i < image1Height; i++) {
            for (int j = 0; j < image1Width; j++) {
                setPixel(i, j, outImage, i, j, image1);
            }
        }

        for (int i = 0; i < image2Height; i++) {
            for (int j = 0; j < image2Width; j++) {
                int resI = i + start[collageDirection.value][0],
                        resJ = j + start[collageDirection.value][1];

                setPixel(i + start[collageDirection.value][0], j + start[collageDirection.value][1], outImage, i, j, image1);
            }
        }
    }

    protected abstract T getOutImage(int outWidth, int outHeight);

    protected abstract void setPixel(int resI, int resJ, T result, int i, int j, T source);
}
