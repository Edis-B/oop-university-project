package logging;

public class ConsoleLoggerProvider implements Logger {
    @Override
    public void sendMessageNewline(String message) {
        System.out.println(message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.print(message);
    }
}
