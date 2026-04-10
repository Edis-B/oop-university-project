package image.actions.rotate;

public enum RotateDirection {
    RIGHT((byte) 1),
    UPSIDE_DOWN((byte) 2),
    LEFT((byte) 3);

    public final byte cwSpins;

    RotateDirection(byte cwSpins) {
        this.cwSpins = cwSpins;
    }
}
