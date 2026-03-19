package image.parsers.ascii;

import image.images_in_memory.ppm.InMemoryPpmAscii;
import image.parsers.ImageParser;

import java.io.BufferedInputStream;
import java.io.IOException;

public class AsciiPpmParser implements ImageParser {
    @Override
    public InMemoryPpmAscii parse(BufferedInputStream bis) throws IOException {
        InMemoryPpmAscii image = new InMemoryPpmAscii();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = bis.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, bytesRead));
        }

        return image;
    }

    @Override
    public String getSupportedFormat() {
        return "P3";
    }
}
