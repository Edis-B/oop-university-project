package image.signatures;

public class BinaryPpmSignature extends NetpbmSignature{
    @Override
    public String getFormatId() {
        return "P6";
    }
}
