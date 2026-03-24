package session;

import image.images_in_memory.InMemoryImage;

public record ImageWrapper(InMemoryImage image, String originalFilePath) {
}
