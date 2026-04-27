package logging;

public class ConsoleLoggerProvider implements Logger {
    @Override
    public void sendErrorNewline(String message) {
        System.err.println(message);
    }

    @Override
    public void sendError(String message) {
        System.err.print(message);
    }

    @Override
    public void sendMessageNewline(String message) {
        System.out.println(message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.print(message);
    }
}
