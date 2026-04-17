package image.factory;

import image.images_in_memory.InMemoryImage;
import image.manipulators.ImageManipulator;
import image.signatures.FormatType;

import java.util.HashMap;
import java.util.Map;

public abstract class ManipulatorFactory<T extends ImageManipulator<? extends InMemoryImage>> extends AbstractFactory<T, FormatType> {

}
