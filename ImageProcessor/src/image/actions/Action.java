package image.actions;

import session.ImageContext;

public interface Action {
    public void execute(ImageContext imageContext);
    public String getCommandString();
}
