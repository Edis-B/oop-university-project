package image.factory;

public interface ClassFactory<T, C> {
    Class<T> search(C type);

    Class<T> getClazz();

    void register(C type, Class<T> clazz);
}
