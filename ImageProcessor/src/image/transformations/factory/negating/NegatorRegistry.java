package image.transformations.factory.negating;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;

import image.transformations.negating.Negator;
import image.transformations.negating.PpmNegator;
import image.signatures.FormatType;
import util.ClassHelper;

import java.util.List;

public class NegatorRegistry {
    public static void registerAll(NegatorFactory factory) {
        List<Class<?>> negatorClasses = ClassHelper
                .getClassesOfPackage(PpmNegator.class.getPackageName());

        for (Class<?> clazz : negatorClasses) {
            if (ClassHelper.isConcrete(clazz) &&
                    Negator.class.isAssignableFrom(clazz)) {
                try {
                    Negator<? extends InMemoryImage> negatorObj =
                            (Negator<? extends InMemoryImage>) clazz.getConstructor().newInstance();

                    for (FormatType supportedFormat : negatorObj.getSupportedFormats()) {
                        factory.register(supportedFormat, negatorObj);
                    }
                } catch (Exception e) {
                    throw new ApplicationException("Error creating Negator!", e);
                }
            }
        }
    }
}
