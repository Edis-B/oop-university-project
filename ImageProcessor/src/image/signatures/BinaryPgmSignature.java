package image.signatures;

public class BinaryPgmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.BINARY_PGM;
    }
}
