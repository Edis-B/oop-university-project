package image.manipulators.compositors.factory;

import image.manipulators.compositors.collage.Collager;
import image.images_in_memory.InMemoryImage;

public class CollagerFactory extends CompositorFactory<Collager<? extends InMemoryImage>> {
    @Override
    public Class<Collager<? extends InMemoryImage>> getClazz() {
        //noinspection unchecked
        return (Class<Collager<? extends InMemoryImage>>) (Class<?>) Collager.class;
    }
}
