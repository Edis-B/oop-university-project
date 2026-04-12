package image.manipulators.transformations.factory;

import image.factory.AbstractFactory;
import image.factory.ManipulationFactory;
import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import image.manipulators.transformations.ImageTransformer;

public abstract class TransformerFactory<T extends ImageTransformer<? extends InMemoryImage>> extends ManipulationFactory<T> {

}
