package cli.commands.registry;

import cli.commands.Command;
import cli.commands.image.*;
import cli.commands.session.*;
import image.parsers.factory.FormatExtractor;
import image.parsers.factory.ParserFactory;
import image.parsers.factory.ParserDiscoverer;
import image.service.ImageLoaderService;
import image.signatures.FormatSignature;
import image.signatures.SignatureFactory;
import logging.ConsoleLoggingProvider;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {
    public List<Command> createAllCommands() {
        List<Command> list = new ArrayList<>();
        ConsoleLoggingProvider clp = new ConsoleLoggingProvider();

        // Image Manipulation
        list.add(new GrayscaleCommand());
        list.add(new MonochromeCommand());
        list.add(new NegativeCommand());
        list.add(new RotateCommand());
        list.add(new UndoCommand());
        list.add(new SessionCommand());
        list.add(new SwitchCommand());
        list.add(new CollageCommand());

        // Session handling
        list.add(new CloseCommand());
        list.add(new ExitCommand());
        list.add(new HelpCommand());

        List<FormatSignature> imageSignatures = SignatureFactory.getInstance().getSignatures();
        FormatExtractor fe = new FormatExtractor(imageSignatures);

        ParserFactory pf = ParserFactory.getInstance();
        ParserDiscoverer.registerAll(pf);

        ImageLoaderService imageLoaderService = new ImageLoaderService(fe, pf);
        list.add(new LoadCommand(imageLoaderService, clp));
        list.add(new AddCommand(imageLoaderService));

        list.add(new SaveCommand());

        return list;
    }
}