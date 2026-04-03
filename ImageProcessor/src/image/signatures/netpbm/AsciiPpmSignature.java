package image.signatures.netpbm;

import image.signatures.FormatType;

public class AsciiPpmSignature extends NetpbmSignature {
    @Override
    public FormatType getFormatType() {
        return FormatType.ASCII_PPM;
    }
}
