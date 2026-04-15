package image.manipulators.annotation;

import image.signatures.FormatType;

import java.util.List;

public class AnnotationHelper {
    public static List<FormatType> getSupportedFormatTypes(Class<?> clazz) {
        return List.of(clazz.getAnnotation(SupportedFormats.class).value());
    }
}
