package cli.commands.registry;

import cli.commands.Command;
import cli.commands.image.*;
import cli.commands.session.*;
import image.io.serializers.ImageSerializer;
import image.io.serializers.factory.SerializerFactory;
import image.io.serializers.factory.SerializerRegistry;
import image.manipulators.compositors.collage.Collager;
import image.manipulators.compositors.factory.CollagerFactory;
import image.manipulators.compositors.factory.registry.CollagerRegistry;
import image.manipulators.transformations.factory.*;
import image.manipulators.transformations.grayscale.Grayscaler;
import image.manipulators.transformations.monochrome.Monochromer;
import image.manipulators.transformations.negative.Negator;
import image.manipulators.transformations.rotate.Rotator;
import image.manipulators.transformations.factory.registry.GrayscalerRegistry;
import image.manipulators.transformations.factory.registry.MonochromerRegistry;
import image.manipulators.transformations.factory.registry.NegatorRegistry;
import image.manipulators.transformations.factory.registry.RotatorRegistry;
import image.service.ImageSerializerService;
import image.signatures.factory.FormatExtractor;
import image.io.parsers.factory.ParserFactory;
import image.io.parsers.factory.ParserDiscoverer;
import image.service.ImageLoaderService;
import image.signatures.FormatSignature;
import image.signatures.factory.SignatureFactory;
import logging.ConsoleLoggerProvider;
import logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
    public List<Command> createAllCommands() {
        List<Command> list = new ArrayList<>(20);

        Logger consoleLoggerProvider = new ConsoleLoggerProvider();

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

        list.add(new UndoCommand(consoleLoggerProvider));

        list.add(new SessionCommand(consoleLoggerProvider));

        list.add(new SwitchCommand(consoleLoggerProvider));

        CollagerFactory collagerFactory = new CollagerFactory();
        CollagerRegistry collagerRegistry = new CollagerRegistry();
        collagerRegistry.registerAll(collagerFactory, Collager.class.getPackageName());
        list.add(new CollageCommand(collagerFactory, consoleLoggerProvider));

        // Session handling
        list.add(new CloseCommand(consoleLoggerProvider));

        list.add(new ExitCommand(consoleLoggerProvider));

        list.add(new HelpCommand(consoleLoggerProvider, list));

        SignatureFactory signatureFactory = new SignatureFactory();
        List<FormatSignature> imageSignatures = signatureFactory.getSignatures();
        FormatExtractor formatExtractor = new FormatExtractor(imageSignatures);

        ParserFactory parserFactory = new ParserFactory();
        ParserDiscoverer.registerAll(parserFactory);

        ImageLoaderService imageLoaderService = new ImageLoaderService(formatExtractor, parserFactory);
        list.add(new LoadCommand(imageLoaderService, consoleLoggerProvider));
        list.add(new AddCommand(imageLoaderService, consoleLoggerProvider));

        SerializerFactory serializerFactory = new SerializerFactory();
        SerializerRegistry serializerRegistry = new SerializerRegistry();
        serializerRegistry.registerAll(serializerFactory, ImageSerializer.class.getPackageName());
        ImageSerializerService imageSerializerService = new ImageSerializerService(serializerFactory);

        list.add(new SaveCommand(consoleLoggerProvider, imageSerializerService));

        return list;
    }
}