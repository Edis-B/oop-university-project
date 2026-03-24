package image.signatures;

public abstract class NetpbmSignature implements FormatSignature {
    @Override
    public int getHeaderSize() { return 2; }

    @Override
    public boolean matches(byte[] bytes) {
        if (bytes == null || bytes.length < 2)
            return false;

        return bytes[0] == (byte)'P' && bytes[1] == (byte) getFormatType().magic.charAt(1);
    }
}
