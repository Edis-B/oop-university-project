package image.signatures;

public class AsciiPpmSignature extends NetpbmSignature{
    @Override
    public FormatType getFormatType() {
        return FormatType.ASCII_PPM;
    }
}
