package image.service;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.parsers.factories.FormatExtractor;
import image.parsers.factories.ParserFactory;
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

    public InMemoryImage load(String filePath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            bis.mark(1024);
            FormatType format = extractor.extract(bis);
            bis.reset();

            return parserFactory.getParser(format).parse(bis);
        } catch (IOException e) {
            throw new ApplicationException("Could not load image: " + e.getMessage());
        }
    }
}
