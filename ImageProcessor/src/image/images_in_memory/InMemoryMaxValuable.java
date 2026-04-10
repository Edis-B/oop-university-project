package image.images_in_memory;

public abstract class InMemoryMaxValuable extends InMemoryImage {
    private final short maxValue;

    public abstract short getDefaultValue();

    public short getMaxValue() { return maxValue; };

    public InMemoryMaxValuable(int width, int height) {
        super(width, height);
        this.maxValue = getDefaultValue();
    }

    public InMemoryMaxValuable(int width, int height, short maxValue) {
        super(width, height);
        this.maxValue = maxValue;
    }

    public abstract InMemoryImage createBlank(int width, int height, short maxValue);
}
