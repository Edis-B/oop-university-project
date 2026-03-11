package session;

import javax.swing.*;
import java.util.Stack;

public class Session {
    private final Stack<Action> commandHistory = new Stack<>();

    public void appendAction(Action action) {
        commandHistory.push(action);
    }

    public void undoAction() {
        commandHistory.pop();
    }
}
