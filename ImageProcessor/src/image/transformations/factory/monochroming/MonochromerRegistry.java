package image.transformations.factory.monochroming;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.transformations.monochroming.Monochromer;
import image.transformations.monochroming.PpmMonochromer;
import image.signatures.FormatType;
import util.ClassHelper;

import java.util.List;

public class MonochromerRegistry {
    public static void registerAll(MonochromerFactory factory) {
        List<Class<?>> monochromerClasses = ClassHelper
                .getClassesOfPackage(PpmMonochromer.class.getPackageName());

        for (Class<?> clazz : monochromerClasses) {
            if (ClassHelper.isConcrete(clazz) &&
                    Monochromer.class.isAssignableFrom(clazz)) {
                try {
                    Monochromer<? extends InMemoryImage> monochromerObj =
                            (Monochromer<? extends InMemoryImage>) clazz.getConstructor().newInstance();

                    for (FormatType supportedFormat : monochromerObj.getSupportedFormats()) {
                        factory.register(supportedFormat, monochromerObj);
                    }
                } catch (Exception e) {
                    throw new ApplicationException("Error creating Monochromer!", e);
                }
            }
        }
    }
}
