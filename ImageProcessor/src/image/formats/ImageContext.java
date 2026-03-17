package image.formats;

import java.util.ArrayList;
import java.util.List;

public class ImageContext {
    private final List<InMemoryImage> images = new ArrayList<>();

    public ImageContext() { }

    public List<InMemoryImage> getImages() {
        return images;
    }
}
