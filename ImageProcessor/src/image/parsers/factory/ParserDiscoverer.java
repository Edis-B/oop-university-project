package image.parsers.factory;

import exceptions.ApplicationException;
import image.parsers.ImageParser;
import util.ClassHelper;

import java.util.List;

// Registers Parser factory (P? -> Parser) by
// using parser.getSupportedFormat()

public class ParserDiscoverer {
    public static void registerAll(ParserFactory factory) {
        var parserPackage = ImageParser.class.getPackageName();

        List<Class<ImageParser>> smt = ClassHelper.getClassesImplementationsInPackage(
                parserPackage,
                ImageParser.class
        );

        for (Class<?> clazz : smt) {
            try {
                Object unknownObject = clazz.getConstructor().newInstance();
                ImageParser ip = (ImageParser) unknownObject;
                factory.register(ip.getSupportedFormat(), ip);
            } catch (Exception e) {
                throw new ApplicationException("Error registering parser!", e);
            }
        }
    }
}
