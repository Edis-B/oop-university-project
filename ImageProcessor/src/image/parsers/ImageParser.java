package image.parsers;

import image.images_in_memory.InMemoryImage;

import java.util.Scanner;

public interface ImageParser {
    InMemoryImage parse(Scanner sc);
}