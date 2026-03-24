package image.signatures;

public class AsciiPbmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.ASCII_PBM;
    }
}
