package image.signatures;

public interface FormatSignature {
    FormatType getFormatType();
    boolean matches(byte[] bytes);
    int getHeaderSize();
}
