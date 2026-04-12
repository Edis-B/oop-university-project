package image.manipulators.compositors.collage;

import image.actions.collage.CollageDirection;
import image.images_in_memory.InMemoryMaxValuable;

public abstract class MaxValuedCollager<T extends InMemoryMaxValuable> extends Collager<T> {
    private double coefficient = -1;

    protected double getCoefficient() {
        if (coefficient == -1) {
            int max1 = image1.getMaxValue(),
                    max2 = image2.getMaxValue();

            if (max1 < max2) {
                int temp = max1;
                max1 = max2;
                max2 = temp;
            }

            coefficient = (double) max1 / max2;
        }

        return coefficient;
    }

    public MaxValuedCollager(T image1, T image2, CollageDirection collageDirection) {
        super(image1, image2, collageDirection);
    }
}
