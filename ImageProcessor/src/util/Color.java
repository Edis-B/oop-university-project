package util;

import java.util.Objects;

public class Color {
    private final short red;
    private final short green;
    private final short blue;

    public Color(short red, short green, short blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public short getRed() { return red; }
    public short getGreen() { return green; }
    public short getBlue() { return blue; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return red == color.red && green == color.green && blue == color.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}