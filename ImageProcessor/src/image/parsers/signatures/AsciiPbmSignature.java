package image.parsers.signatures;

public class AsciiPbmSignature extends NetpbmSignature {
    @Override
    public String getFormatId() {
        return "P1";
    }
}
