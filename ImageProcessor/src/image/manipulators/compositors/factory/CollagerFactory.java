package image.manipulators.compositors.factory;

import image.manipulators.compositors.collage.Collager;
import image.images_in_memory.InMemoryImage;

public class CollagerFactory extends CompositorFactory<Collager<InMemoryImage>> {
    @Override
    public Class<Collager<InMemoryImage>> getClazz() {
        //noinspection unchecked
        return (Class<Collager<InMemoryImage>>) (Class<?>) Collager.class;
    }
}
