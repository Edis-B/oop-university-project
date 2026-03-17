package session;

import image.actions.Action;

import java.util.Stack;

public class Session {
    private final Stack<Action> commandHistory = new Stack<>();

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
