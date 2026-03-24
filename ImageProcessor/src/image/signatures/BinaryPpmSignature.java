package image.signatures;

public class BinaryPpmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.BINARY_PPM;
    }
}
