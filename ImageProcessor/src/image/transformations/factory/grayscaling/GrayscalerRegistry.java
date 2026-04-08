package image.transformations.factory.grayscaling;

import exceptions.ApplicationException;
import image.transformations.grayscaling.Grayscaler;
import image.transformations.grayscaling.PpmGrayscaler;
import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import util.ClassHelper;

import java.util.List;

public class GrayscalerRegistry {
    public static void registerAll(GrayscalerFactory factory) {
        List<Class<?>> grayscalerClasses = ClassHelper
                .getClassesOfPackage(PpmGrayscaler.class.getPackageName());

        for (Class<?> clazz : grayscalerClasses) {
            if (ClassHelper.isConcrete(clazz) &&
                    Grayscaler.class.isAssignableFrom(clazz)) {
                try {
                    Grayscaler<? extends InMemoryImage> grayscalerObj =
                            (Grayscaler<? extends InMemoryImage>) clazz.getConstructor().newInstance();

                    for (FormatType supportedFormat : grayscalerObj.getSupportedFormats()) {
                        factory.register(supportedFormat, grayscalerObj);
                    }
                } catch (Exception e) {
                    throw new ApplicationException("Error creating Grayscaler!", e);
                }
            }
        }
    }
}
