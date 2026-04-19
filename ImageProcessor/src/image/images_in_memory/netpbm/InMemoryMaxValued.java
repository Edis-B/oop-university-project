package image.images_in_memory.netpbm;

public abstract class InMemoryMaxValued extends InMemoryNetpbm {
    protected final short maxValue;

    public abstract short getDefaultValue();

    public short getMaxValue() { return maxValue; };

    public InMemoryMaxValued(int width, int height) {
        super(width, height);
        this.maxValue = getDefaultValue();
    }

    public InMemoryMaxValued(int width, int height, short maxValue) {
        super(width, height);
        this.maxValue = maxValue;
    }

    public abstract InMemoryMaxValued createBlank(int width, int height, short maxValue);
}
