package logging;

public interface Logger {
    void sendErrorNewline(String message);

    void sendError(String message);

    void sendMessageNewline(String message);

    void sendMessage(String message);
}
