package image.parsers.signatures;

public class BinaryPbmSignature extends  NetpbmSignature{
    @Override
    public String getFormatId() {
        return "P4";
    }
}
