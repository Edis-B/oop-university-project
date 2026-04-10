package util;

import exceptions.ApplicationException;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ClassHelper {
    private ClassHelper() {
    }

    public static boolean isConcrete(Class<?> clazz) {
        int modifiers = clazz.getModifiers();

        boolean isInterface = clazz.isInterface();
        boolean isAbstract = Modifier.isAbstract(modifiers);

        return !isInterface && !isAbstract;
    }

    public static List<Class<?>> getClassesInPackage(String packageName) {
        try {
            String path = packageName.replace('.', '/');
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            var resource = classLoader.getResource(path);

            if (resource == null)
                return new ArrayList<>();

            File directory = new File(resource.getFile());
            List<Class<?>> classes = new ArrayList<>();

            for (File file : directory.listFiles()) {
                if (file.getName().endsWith(".class")) {
                    String fileName = file.getName().replace(".class", "");
                    String className = packageName + '.' + fileName;
                    Class<?> clazz = Class.forName(className);
                    classes.add(clazz);
                } else if (file.isDirectory()) {
                    String subPackageName = packageName + "." + file.getName();
                    classes.addAll(getClassesInPackage(subPackageName));
                }
            }

            return classes;
        } catch (ClassNotFoundException e) {
            throw new ApplicationException("Class not found during scan!");
        } catch (Exception e) {
            throw new ApplicationException("Error scanning package!");
        }
    }

    public static <T> List<Class<T>> getClassesImplementationsInPackage(String packageName, Class<T> superClass) {
        List<Class<?>> classesInPackage = getClassesInPackage(packageName);
        List<Class<T>> result = new ArrayList<>();

        for (Class<?> clazz : classesInPackage) {
            if (ClassHelper.isConcrete(clazz) && superClass.isAssignableFrom(clazz)) {
                //noinspection unchecked
                result.add((Class<T>) clazz);
            }
        }

        return result;
    }

    public static String getParentPackage(String packageName) {
        int lastDot = packageName.lastIndexOf('.');
        if (lastDot == -1) return "";
        return packageName.substring(0, lastDot);
    }
}
