package image.signatures.netpbm;

import image.signatures.FormatType;

public class BinaryPgmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.BINARY_PGM;
    }
}
