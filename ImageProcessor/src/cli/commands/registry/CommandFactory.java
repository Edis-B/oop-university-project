package cli.commands.registry;

import cli.commands.Command;
import cli.commands.image.*;
import cli.commands.session.*;
import image.parsers.ImageParser;
import image.parsers.ascii.AsciiPbmParser;
import image.parsers.factories.FormatExtractor;
import image.parsers.factories.ParserFactory;
import image.parsers.factories.ParserRegistry;
import image.signatures.FormatSignature;
import image.signatures.SignatureFactory;
import util.ClassHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommandFactory {
    public List<Command> createAllCommands() {
        List<Command> list = new ArrayList<>();

        // Image Manipulation
        list.add(new GrayscaleCommand());
        list.add(new MonochromeCommand());
        list.add(new NegativeCommand());
        list.add(new RotateCommand());
        list.add(new UndoCommand());
        list.add(new AddCommand());
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
        ParserRegistry.registerAll(pf);
        list.add(new LoadCommand(fe, pf));

        list.add(new SaveCommand());

        return list;
    }
}