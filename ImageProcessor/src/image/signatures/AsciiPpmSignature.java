package image.signatures;

public class AsciiPpmSignature extends NetpbmSignature{
    @Override
    public String getFormatId() {
        return "P3";
    }
}
