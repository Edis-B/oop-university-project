package session;

import image.actions.Action;

public class SessionManager {
    private final Session session;

    public SessionManager(Session session) {
        this.session = session;
    }

    public void addCommandToSession(Action action) {
        session.appendAction(action);
    }
}
