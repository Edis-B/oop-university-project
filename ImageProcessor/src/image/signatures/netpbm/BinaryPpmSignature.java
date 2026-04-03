package image.signatures.netpbm;

import image.signatures.FormatType;

public class BinaryPpmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.BINARY_PPM;
    }
}
