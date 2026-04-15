package image.manipulators.compositors.factory.registry;

import exceptions.ApplicationException;
import image.factory.registry.ManipulatorRegistry;
import image.images_in_memory.InMemoryImage;
import image.manipulators.compositors.collage.Collager;

public class CollagerRegistry implements ManipulatorRegistry<Collager<? extends InMemoryImage>> {

}
