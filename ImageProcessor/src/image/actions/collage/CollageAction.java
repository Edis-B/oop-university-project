package image.actions.collage;

import exceptions.ApplicationException;
import image.actions.Action;
import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;
import session.ImageContext;

public class CollageAction implements Action {
    private final String image1Name;
    private final String image2Name;
    private final CollageDirection collageDirection;
    private final String imageOutName;

    public CollageAction(String image1Name, String image2Name, CollageDirection collageDirection, String imageOutName) {
        this.image1Name = image1Name;
        this.image2Name = image2Name;
        this.collageDirection = collageDirection;
        this.imageOutName = imageOutName;
    }

    @Override
    public void execute(ImageContext imageContext) {
        InMemoryImage image1 = imageContext.getImageWrapperByName(image1Name).getImage(),
                image2 = imageContext.getImageWrapperByName(image2Name).getImage();

        StringBuilder sb = new StringBuilder();

        if (image1 == null)
            sb.append(image1Name).append(", ");

        if (image2 == null)
            sb.append(image2Name);

        if (!sb.isEmpty())
            throw new ApplicationException("Cannot collage images (not found) - " + sb.toString());

        FormatType image1Format = image1.getFormat(),
                image2Format = image2.getFormat();

        if (!image1Format.extension.equals(image2Format.extension))
            throw new ApplicationException(
                    String.format("Cannot make a collage from different types! (%s and %s)", image1Format.extension, image2Format.extension)
            );



    }
}
