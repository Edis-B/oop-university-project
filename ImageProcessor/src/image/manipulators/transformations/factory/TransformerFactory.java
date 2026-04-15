package image.manipulators.transformations.factory;

import image.factory.ManipulatorFactory;
import image.images_in_memory.InMemoryImage;
import image.manipulators.transformations.ImageTransformer;

public abstract class TransformerFactory<T extends ImageTransformer<? extends InMemoryImage>> extends ManipulatorFactory<T> {

}
