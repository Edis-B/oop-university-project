package image.parsers.factory;

import exceptions.ApplicationException;
import image.signatures.FormatSignature;
import image.signatures.FormatType;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;

public class FormatExtractor {
    private final List<FormatSignature> signatureList;

    public FormatExtractor(List<FormatSignature> signatureList) {
        this.signatureList = signatureList;
    }

    public FormatType extract(BufferedInputStream bis) {
        try {
            byte[] bytes = new byte[16];
            int bytesRead = bis.read(bytes, 0, 16);

            if (bytesRead == -1)
                throw new ApplicationException("File is empty!");

            for (var signature : signatureList) {
                if (bytesRead >= signature.getHeaderSize() && signature.matches(bytes)) {
                    return signature.getFormatType();
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("IO exception occurred!");
        }

        throw new ApplicationException("Unsupported file type!");
    }
}
