package session;

import image.actions.Action;

import java.util.*;

public class Session {
    private final Stack<Action> commandHistory = new Stack<>();
    private final LinkedList<ImageWrapper> loadedImages = new LinkedList<>();

    public LinkedList<ImageWrapper> getLoadedImages() {
        return (LinkedList<ImageWrapper>) List.copyOf(loadedImages);
    }

    protected Session() {
    }

    public void addFirst(ImageWrapper image) {
        loadedImages.addFirst(image);
    }

    public void removeFirst() {
        loadedImages.removeFirst();
    }

    public void removeLast() {
        loadedImages.removeLast();
    }

    public void appendAction(Action action) {
        commandHistory.push(action);
    }

    public void undoAction() {
        commandHistory.pop();
    }

    public Stack<Action> getCommandHistory() {
        return commandHistory;
    }
}
