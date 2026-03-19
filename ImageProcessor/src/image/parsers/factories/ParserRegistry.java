package image.parsers.factories;

import exceptions.ApplicationException;
import image.parsers.ImageParser;
import image.parsers.ascii.AsciiPbmParser;
import util.ClassHelper;

import java.util.List;

public class ParserRegistry {
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
