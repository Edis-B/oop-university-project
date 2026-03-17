package image.formats;

import util.Triple;

import java.util.List;

public class InMemoryPPM extends InMemoryImage {
    private int maxValue;

    List<List<Triple<Short, Short, Short>>> pixels;
}

