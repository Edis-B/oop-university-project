package image.parsers.signatures;

public class BinaryPpmSignature extends NetpbmSignature{
    @Override
    public String getFormatId() {
        return "P6";
    }
}
