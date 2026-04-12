package image.manipulators.compositors.factory;

import image.factory.ManipulationFactory;
import image.manipulators.compositors.ImageCompositor;
import image.factory.AbstractFactory;
import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

public abstract class CompositorFactory<T extends ImageCompositor<? extends InMemoryImage>> extends ManipulationFactory<T> {
}
