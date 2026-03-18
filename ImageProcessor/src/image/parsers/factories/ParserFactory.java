package image.parsers.factories;

import exceptions.ApplicationException;
import image.parsers.ImageParser;

import java.util.HashMap;
import java.util.Map;

public class ParserFactory {
    private final Map<String, ImageParser> formatDict = new HashMap<>();

    private ParserFactory() {
    }

    public void register(String id, ImageParser imageParser) {
        formatDict.put(id, imageParser);
    }

    public ImageParser getParser(String formatId) {
        if (!formatDict.containsKey(formatId))
            throw new ApplicationException("Unknown file format");

        return formatDict.get(formatId);
    }
}
