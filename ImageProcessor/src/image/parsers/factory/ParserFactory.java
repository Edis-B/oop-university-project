package image.parsers.factory;

import exceptions.ApplicationException;
import image.parsers.contracts.ImageParser;
import image.signatures.FormatType;

import java.util.HashMap;
import java.util.Map;

// FormatType -> Parser
public class ParserFactory {
    private final Map<FormatType, ImageParser> formatDict = new HashMap<>();

    private ParserFactory() {
    }

    private static ParserFactory instance;
    public static ParserFactory getInstance() {
        if (instance == null)
            instance = new ParserFactory();

        return instance;
    }

    public void register(FormatType formatType, ImageParser imageParser) {
        formatDict.put(formatType, imageParser);
    }

    public ImageParser getParser(FormatType formatType) {
        if (!formatDict.containsKey(formatType))
            throw new ApplicationException("Unknown file format");

        return formatDict.get(formatType);
    }
}
