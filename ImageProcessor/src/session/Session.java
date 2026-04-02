package session;

import image.ImageContext;
import image.actions.Action;
import image.images_in_memory.InMemoryImage;

import java.util.*;

public class Session {
    private final Stack<Action> commandHistory = new Stack<>();
    private final ImageContext imageContext = new ImageContext();
    private final int id;

    public int getId() {
        return id;
    }

    public ImageContext getImageContext() {
        return imageContext;
    }

    public void addImage(InMemoryImage image, String filePath) {
        imageContext.insertImage(image, filePath);
    }

    public int getImageCount() {
        return imageContext.getImageCount();
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

    public Stack<Action> getCommandHistory() {
        Stack<Action> copy = new Stack<>();
        copy.addAll(this.commandHistory);
        return copy;
    }
}
