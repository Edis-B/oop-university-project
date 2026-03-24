package image.signatures;

public class AsciiPgmSignature extends NetpbmSignature{
    @Override
    public FormatType getFormatType() {
        return FormatType.ASCII_PGM;
    }
}
