package exceptions;

public class CommandException extends ApplicationException {
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandException(String message) {
        super(message);
    }
}
