package image.signatures;

public class BinaryPbmSignature extends  NetpbmSignature{
    @Override
    public String getFormatId() {
        return "P4";
    }
}
