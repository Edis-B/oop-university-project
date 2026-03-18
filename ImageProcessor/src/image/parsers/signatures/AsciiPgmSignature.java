package image.parsers.signatures;

public class AsciiPgmSignature extends NetpbmSignature{
    @Override
    public String getFormatId() {
        return "P2";
    }
}
