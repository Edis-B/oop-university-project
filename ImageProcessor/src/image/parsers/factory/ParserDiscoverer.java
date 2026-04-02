package image.parsers.factory;

import exceptions.ApplicationException;
import image.parsers.contracts.ImageParser;
import image.parsers.ascii.AsciiPbmParser;
import util.ClassHelper;

import java.util.List;

// Registers Parser factory (P? -> Parser) by
// using parser.getSupportedFormat()

public class ParserDiscoverer {
    public static void registerAll(ParserFactory factory) {
        AsciiPbmParser asciiPbmParser = new AsciiPbmParser();
        List<Class<?>> smt = ClassHelper.getClassesOfPackage(ClassHelper.getParentPackage(asciiPbmParser.getClass().getPackage().getName()));
        for (Class<?> clazz : smt) {
            if (!ClassHelper.isConcrete(clazz) || !ImageParser.class.isAssignableFrom(clazz))
                continue;

            try {
                Object unknownObject = clazz.getConstructor().newInstance();
                if (!(unknownObject instanceof ImageParser))
                    continue;

                ImageParser ip = (ImageParser) unknownObject;
                factory.register(ip.getSupportedFormat(), ip);
            } catch (Exception e) {
                throw new ApplicationException("Error registering parser!", e);
            }
        }
    }
}
