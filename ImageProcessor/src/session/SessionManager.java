package session;

import exceptions.ApplicationException;
import image.actions.Action;
import image.images_in_memory.InMemoryImage;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    public int getCurrentSessionId() {
        return session.getId();
    }

    public int newSession() {
        int newId = sessionMap.size() + 1;
        session = new Session(newId);
        sessionMap.put(newId, session);

        return newId;
    }

    public boolean switchToSession(int newId) {
        if (newId == 0) {
            session = null;
            return true;
        }

        if (!sessionMap.containsKey(newId)) {
            throw new ApplicationException(String.format("Session with id: %d, does not exist", newId));
        }

        session = sessionMap.get(newId);
        return true;
    }

    public void addCommandToSession(Action action) {
        if (session == null)
            throw new ApplicationException("Cannot add command to session: not in Session!");

        session.appendAction(action);
    }

    public void insertImageIntoSession(InMemoryImage image, String filePath) {
        if (session == null)
            throw new ApplicationException("Cannot add image to session: not in Session!");

        session.addImage(image, filePath);
    }

    public ImageContext getCurrentImageContext() {
        if (session == null) return null;
        return session.getImageContext();
    }

    public int getCurrentSessionImageCount() {
        return session.getImageCount();
    }

    public int getCurrentTransformationsCount() {
        return session.getTransformationCount();
    }

    public ImageContext executeActionsOnAllImages() {
        ImageContext copiedContext = new ImageContext(session.getImageContext());
        Stack<Action> commandActions = session.getCommandHistory();

        for (Action action : commandActions) {
            action.execute(copiedContext);
        }

        return copiedContext;
    }

    public ImageContext executeActionsOnTheFirstImage() {
        ImageContext context = session.getImageContext();

        ImageContext copiedContext = new ImageContext();
        ImageWrapper copiedFirstWrapper = new ImageWrapper(context.getImageWrapperArray().getFirst());
        copiedContext.insertWrapper(copiedFirstWrapper);
        Stack<Action> commandActions = session.getCommandHistory();

        for (Action action : commandActions) {
            action.execute(copiedContext);
        }

        return copiedContext;
    }
}
