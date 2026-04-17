package image.factory.registry;

import image.factory.ClassFactory;
import util.ClassHelper;

import java.util.List;

public interface ClassRegistry<T, C> {
    default void registerAll(ClassFactory<T, C> factory, String packageName) {
        Class<T> clazz = factory.getClazz();

        List<Class<T>> manipulatorClasses = ClassHelper
                .getClassesImplementationsInPackage(packageName, clazz);

        for (Class<T> cl : manipulatorClasses) {
            List<C> keys = getFactoryKey(cl);
            for (C supportedFormat : keys) {
                factory.register(supportedFormat, cl);
            }
        }
    }

    List<C> getFactoryKey(Class<T> clazz);
}
