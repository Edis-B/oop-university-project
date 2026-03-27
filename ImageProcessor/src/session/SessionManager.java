package session;

import exceptions.ApplicationException;
import image.actions.Action;
import image.ImageContext;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private Session session;
    private final Map<Integer, Session> sessionMap;

    public SessionManager() {
        this.session = null;
        sessionMap = new HashMap<>();
    }

    public Session getCurrentSession() {
        return session;
    }

    public int newSession() {
        int newId = sessionMap.size() + 1;
        session = new Session(newId);
        sessionMap.put(newId, session);

        return newId;
    }

    public boolean switchToSession(int newId) {
        if (!sessionMap.containsKey(newId))
            throw new ApplicationException(String.format("Session with id: %d, does not exist", newId));

        session = sessionMap.get(newId);
        return true;
    }

    public void addCommandToSession(Action action) {
        if (session == null)
            throw new ApplicationException("Session is invalid!");

        session.appendAction(action);
    }

    public ImageContext executeActions() {
        ImageContext imageContext = new ImageContext();
        var commandActions = session.getCommandHistory();

        for (var action : commandActions) {
            action.execute(imageContext);
        }

        return imageContext;
    }
}
