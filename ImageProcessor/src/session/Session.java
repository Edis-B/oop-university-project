package session;

import image.actions.Action;
import image.actions.TransformationAction;
import image.images_in_memory.InMemoryImage;

import java.util.*;

public class Session {
    private final Stack<Action> commandHistory = new Stack<>();
    private final ImageContext imageContext = new ImageContext();
    private final int id;


    public ImageContext getImageContext() {
        return imageContext;
    }

    public void addImage(InMemoryImage image, String filePath) {
        imageContext.insertImage(image, filePath);
    }

    protected Session(int id) {
        this.id = id;
    }

    public void appendAction(Action action) {
        commandHistory.push(action);
    }

    public void undoAction() {
        commandHistory.pop();
    }

    public int getId() {
        return id;
    }

    public int getTransformationCount() {
        return commandHistory.size();
    }

    public int getImageCount() {
        return imageContext.getImageWrapperCount();
    }

    public Stack<Action> getCommandHistory() {
        Stack<Action> copy = new Stack<>();
        copy.addAll(this.commandHistory);
        return copy;
    }
}
