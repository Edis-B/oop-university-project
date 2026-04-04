package image.images_in_memory;

import exceptions.ApplicationException;

public abstract class InMemoryNetpbm extends InMemoryImage {
    protected final short maxValue;

    public InMemoryNetpbm(int width, int height, short maxValue) {
        super(width, height);
        if (maxValue > getDefaultValue())
            throw new ApplicationException("Color value bigger than expected!");

        this.maxValue = maxValue;
    }

    public InMemoryNetpbm(int width, int height) {
        super(width, height);
        this.maxValue = getDefaultValue();
    }

    public abstract short getDefaultValue();

    public short getMaxValue() {
        return maxValue;
    }
}
