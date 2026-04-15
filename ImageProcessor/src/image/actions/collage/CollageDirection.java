package image.actions.collage;

public enum CollageDirection {
    HORIZONTAL(0),
    VERTICAL(1);

    private final int value;

    public int getValue() {
        return value;
    }

    public static CollageDirection get(String input) {
        for (var item : CollageDirection.values())
            if (item.toString().equalsIgnoreCase(input))
                return item;

        return null;
    }

    CollageDirection(int i) {
        value = i;
    }
}
