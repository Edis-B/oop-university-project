package image.manipulators.annotation;

import image.signatures.FormatType;

import java.util.ArrayList;
import java.util.List;

public class AnnotationHelper {
    public static List<FormatType> getSupportedFormatTypes(Class<?> clazz) {
        try {
            return List.of(clazz.getAnnotation(SupportedFormats.class).value());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
