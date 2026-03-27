package session;

import image.actions.Action;

import java.util.*;

public class Session {

    private final Stack<Action> commandHistory = new Stack<>();
    private final List<ImageWrapper> loadedImages = new ArrayList<>();
    private final int id;

    public int getId() {
        return id;
    }

    public List<ImageWrapper> getLoadedImages() {
        return (ArrayList<ImageWrapper>) List.copyOf(loadedImages);
    }

    protected Session(int id) {
        this.id = id;
    }

    public void addImage(ImageWrapper image) {
        loadedImages.addFirst(image);
    }

    public int getImageCount() {
        return loadedImages.size();
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
