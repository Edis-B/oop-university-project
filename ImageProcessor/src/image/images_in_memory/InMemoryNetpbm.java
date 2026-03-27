package image.images_in_memory;

import exceptions.ApplicationException;

public abstract class InMemoryNetpbm extends InMemoryImage {
    protected final int maxValue;

    public InMemoryNetpbm(int width, int height, int maxValue) {
        super(width, height);
        if (maxValue > getDefaultValue())
            throw new ApplicationException("Color value bigger than expected!");

        this.maxValue = maxValue;
    }

    public InMemoryNetpbm(int width, int height) {
        super(width, height);
        this.maxValue = getDefaultValue();
    }

    public abstract int getDefaultValue();

    public int getMaxValue() {
        return maxValue;
    }
}
