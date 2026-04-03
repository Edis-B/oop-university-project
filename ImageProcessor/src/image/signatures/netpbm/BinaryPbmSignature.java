package image.signatures.netpbm;

import image.signatures.FormatType;

public class BinaryPbmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.BINARY_PBM;
    }
}
