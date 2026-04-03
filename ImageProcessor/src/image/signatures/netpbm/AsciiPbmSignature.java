package image.signatures.netpbm;

import image.signatures.FormatType;

public class AsciiPbmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.ASCII_PBM;
    }
}
