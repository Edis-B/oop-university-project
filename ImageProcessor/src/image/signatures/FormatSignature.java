package image.signatures;

public interface FormatSignature {
    String getFormatId();
    boolean matches(byte[] bytes);
    int getHeaderSize();
}
