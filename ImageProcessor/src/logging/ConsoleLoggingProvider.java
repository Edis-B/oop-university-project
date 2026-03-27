package logging;

import cli.commands.session.LoadCommand;

public class ConsoleLoggingProvider {
    public void sendMessageNewline(String message) {
        System.out.println(message);
    }

    public void sendMessage(String message) {
        System.out.print(message);
    }
}
