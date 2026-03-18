package image.parsers.signatures;

public class AsciiPpmSignature extends NetpbmSignature{
    @Override
    public String getFormatId() {
        return "P3";
    }
}
