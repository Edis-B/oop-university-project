package image.manipulators.compositors.factory;

import image.factory.ManipulatorFactory;
import image.manipulators.compositors.ImageCompositor;
import image.images_in_memory.InMemoryImage;

public abstract class CompositorFactory<T extends ImageCompositor<? extends InMemoryImage>> extends ManipulatorFactory<T> {
}
