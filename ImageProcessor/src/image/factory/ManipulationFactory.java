package image.factory;

import image.images_in_memory.InMemoryImage;
import image.manipulators.ImageManipulator;
import image.signatures.FormatType;

public abstract class ManipulationFactory<T extends ImageManipulator<? extends InMemoryImage>> extends AbstractFactory<T, FormatType> {
}
