package image.parsers.signatures;

public class BinaryPgmSignature extends NetpbmSignature {
    @Override
    public String getFormatId() {
        return "P5";
    }
}
