package image.signatures;

public class BinaryPbmSignature extends  NetpbmSignature{
    @Override
    public FormatType getFormatType() {
        return FormatType.BINARY_PBM;
    }
}
