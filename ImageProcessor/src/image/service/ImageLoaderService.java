package image.service;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.signatures.factory.FormatExtractor;
import image.io.parsers.factory.ParserFactory;
import image.signatures.FormatType;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageLoaderService {
    private final ParserFactory parserFactory;
    private final FormatExtractor extractor;

    private ImageLoaderService() {
        this(null, null);
    }

    public ImageLoaderService(FormatExtractor extractor, ParserFactory parserFactory) {
        this.extractor = extractor;
        this.parserFactory = parserFactory;
    }

    public InMemoryImage load(String filePath) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            bis.mark(1024);
            FormatType format = extractor.extract(bis);
            bis.reset();

            return parserFactory.getParser(format).parse(bis);
        } catch (IOException e) {
            throw new IOException("Could not load image: " + e.getMessage(), e);
        }
    }
}
