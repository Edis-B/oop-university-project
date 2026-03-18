package image.actions;

import exceptions.ApplicationException;
import image.ImageContext;

import image.images_in_memory.InMemoryImage;

import image.parsers.ImageParser;
import image.parsers.factories.FormatExtractor;
import image.parsers.factories.ParserFactory;

import java.io.*;

public class AddAction extends Action {
    private final ParserFactory parserFactory;
    private final FormatExtractor extractor;
    private final String filePath;

    public AddAction(String filePath, FormatExtractor extractor, ParserFactory parserFactory) {
        this.parserFactory = parserFactory;
        this.extractor = extractor;
        this.filePath = filePath;
    }

    @Override
    public void execute(ImageContext imageContext) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis);

            bis.mark(1024);
            String format = extractor.extract(bis);
            bis.reset();

            ImageParser imageParser = parserFactory.getParser(format);
            InMemoryImage newImage = imageParser.parse(bis);

            imageContext.insertImage(newImage);
        }
        catch (FileNotFoundException e) {
            throw new ApplicationException("File not found!");
        }
        catch (IOException e) {
            throw new ApplicationException("IO exception occurred!");
        }
    }
}
