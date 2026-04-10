package cli.commands.registry;

import cli.commands.Command;
import cli.commands.image.*;
import cli.commands.session.*;
import image.images_in_memory.InMemoryImage;
import image.transformations.ImageTransformer;
import image.transformations.factory.*;
import image.transformations.grayscaling.Grayscaler;
import image.transformations.monochroming.Monochromer;
import image.transformations.negating.Negator;
import image.transformations.rotating.Rotator;
import image.transformations.registry.GrayscalerRegistry;
import image.transformations.registry.MonochromerRegistry;
import image.transformations.registry.NegatorRegistry;
import image.transformations.registry.RotatorRegistry;
import image.signatures.factory.FormatExtractor;
import image.parsers.factory.ParserFactory;
import image.parsers.factory.ParserDiscoverer;
import image.service.ImageLoaderService;
import image.signatures.FormatSignature;
import image.signatures.factory.SignatureFactory;
import logging.ConsoleLoggingProvider;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
    public List<Command> createAllCommands() {
        List<Command> list = new ArrayList<>(20);

        ConsoleLoggingProvider clp = new ConsoleLoggingProvider();

        // Image Manipulation
        GrayscalerFactory grayscalerFactory = new GrayscalerFactory();
        GrayscalerRegistry grayscalerRegistry = new GrayscalerRegistry();
        grayscalerRegistry.registerAll(grayscalerFactory, Grayscaler.class.getPackageName());
        list.add(new GrayscaleCommand(grayscalerFactory));

        MonochromerFactory monochromerFactory = new MonochromerFactory();
        MonochromerRegistry monochromerRegistry = new MonochromerRegistry();
        monochromerRegistry.registerAll(monochromerFactory, Monochromer.class.getPackageName());
        list.add(new MonochromeCommand(monochromerFactory));

        NegatorFactory negatorFactory = new NegatorFactory();
        NegatorRegistry negatorRegistry = new NegatorRegistry();
        negatorRegistry.registerAll(negatorFactory, Negator.class.getPackageName());
        list.add(new NegativeCommand(negatorFactory));

        RotatorFactory rotatorFactory = new RotatorFactory();
        RotatorRegistry rotatorRegistry = new RotatorRegistry();
        rotatorRegistry.registerAll(rotatorFactory, Rotator.class.getPackageName());
        list.add(new RotateCommand(rotatorFactory));

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