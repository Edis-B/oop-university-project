package image.formats;

import java.util.List;

public class InMemoryPGM extends InMemoryImage {
    private int maxValue;

    List<List<Short>> pixels;
}
