package image.signatures.netpbm;

import image.signatures.FormatType;

public class AsciiPgmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.ASCII_PGM;
    }
}
