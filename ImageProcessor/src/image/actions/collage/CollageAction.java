package image.actions.collage;

import exceptions.ApplicationException;
import image.actions.Action;
import image.images_in_memory.InMemoryImage;
import image.manipulators.compositors.collage.Collager;
import image.manipulators.compositors.factory.CollagerFactory;
import image.signatures.FormatType;
import session.ImageContext;
import session.ImageWrapper;

public class CollageAction implements Action {
    private final String image1Name;
    private final String image2Name;
    private final CollageDirection collageDirection;
    private final String imageOutName;
    private final CollagerFactory collagerFactory;

    public CollageAction(CollageDirection collageDirection, String image1Name, String image2Name, String imageOutName, CollagerFactory collagerFactory) {
        this.image1Name = image1Name;
        this.image2Name = image2Name;
        this.collageDirection = collageDirection;
        this.imageOutName = imageOutName;
        this.collagerFactory = collagerFactory;
    }

    @Override
    public void execute(ImageContext imageContext) {
        ImageWrapper image1Wrapper = imageContext.getImageWrapperByName(image1Name),
                image2Wrapper = imageContext.getImageWrapperByName(image2Name);

        StringBuilder sb = new StringBuilder();

        if (image1Wrapper == null) sb.append(image1Name).append(", ");
        if (image2Wrapper == null) sb.append(image2Name);
        if (!sb.isEmpty()) throw new ApplicationException("Cannot collage images (not found) - " + sb.toString());

        assert image1Wrapper != null;
        FormatType image1Format = image1Wrapper.getImage().getFormat();

        assert image2Wrapper != null;
        FormatType image2Format = image2Wrapper.getImage().getFormat();

        if (!image1Format.extension.equals(image2Format.extension))
            throw new ApplicationException(String.format("Cannot make a collage from different types! (%s and %s)", image1Format.extension, image2Format.extension));

        InMemoryImage image1 = image1Wrapper.getImage(),
                image2 = image2Wrapper.getImage();

        Class<Collager<? extends InMemoryImage>> collagerClass = collagerFactory.search(image1Format);
        Collager<? extends InMemoryImage> collagerInstance = resolveConcreteCollager(image1, image2, collageDirection, collagerClass);

        InMemoryImage outImage = collagerInstance.execute(imageContext);
        imageContext.insertImage(outImage, imageOutName);
    }

    private Collager<? extends InMemoryImage> resolveConcreteCollager(
            InMemoryImage img1,
            InMemoryImage img2,
            CollageDirection dir,
            Class<Collager<? extends InMemoryImage>> collagerClass) {
        try {
            for (var constructor : collagerClass.getConstructors()) {
                Class<?>[] params = constructor.getParameterTypes();

                if (params.length == 3
                        && params[0].isInstance(img1)
                        && params[1].isInstance(img2)
                        && params[2] == CollageDirection.class) {

                    return (Collager<? extends InMemoryImage>) constructor.newInstance(img1, img2, dir);
                }
            }

            throw new NoSuchMethodException("No suitable constructor found for the given image types.");

        } catch (Exception e) {
            throw new ApplicationException("Couldn't instantiate collager!", e);
        }
    }
}
