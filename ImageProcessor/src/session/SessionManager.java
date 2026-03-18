package session;

import exceptions.ApplicationException;
import image.actions.Action;
import image.ImageContext;

public class SessionManager {
    private Session session;

    public SessionManager() {
        this.session = null;
    }

    public Session getSession() {
        return session;
    }

    public void startSession() {
        session = new Session();
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
