package util;

import java.lang.reflect.Modifier;

public class ClassInspector {
    public static boolean isConcrete(Class<?> clazz) {
        int modifiers = clazz.getModifiers();

        boolean isInterface = clazz.isInterface();
        boolean isAbstract = Modifier.isAbstract(modifiers);

        return !isInterface && !isAbstract;
    }
}
