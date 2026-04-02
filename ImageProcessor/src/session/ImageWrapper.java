package session;

import image.images_in_memory.InMemoryImage;

import java.util.Objects;

public final class ImageWrapper {
    private final InMemoryImage image;
    private final String originalFilePath;
    private final String name;

    public ImageWrapper(InMemoryImage image, String originalFilePath, String name) {
        this.image = image;
        this.name = name;
        this.originalFilePath = originalFilePath;
    }

    public InMemoryImage getImage() {
        return image;
    }

    public String getOriginalFilePath() {
        return originalFilePath;
    }

    public String getName() {
        return name;
    }
}
