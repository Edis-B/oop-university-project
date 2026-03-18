package image.parsers.factories;

import exceptions.ApplicationException;
import image.parsers.signatures.FormatSignature;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormatExtractor {
    private final List<FormatSignature> signatureList = new ArrayList<>();

    public FormatExtractor() {
    }

    public void register(FormatSignature fs) {
        signatureList.add(fs);
    }

    public String extract(BufferedInputStream bis) {
        try {
            byte[] bytes = new byte[16];
            int bytesRead = bis.read(bytes, 0, 16);

            if (bytesRead == -1)
                throw new ApplicationException("File is empty!");

            for (var signature : signatureList) {
                if (bytesRead >= signature.getHeaderSize() && signature.matches(bytes)) {
                    return signature.getFormatId();
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("IO exception occurred!");
        }

        throw new ApplicationException("Unsupported file type!");
    }
}
