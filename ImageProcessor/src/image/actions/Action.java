package image.actions;

import image.ImageContext;

import java.io.FileNotFoundException;

public abstract class Action {
    public abstract void execute(ImageContext imageContext);
}
