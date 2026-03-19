package image.signatures;

public class AsciiPbmSignature extends NetpbmSignature {
    @Override
    public String getFormatId() {
        return "P1";
    }
}
