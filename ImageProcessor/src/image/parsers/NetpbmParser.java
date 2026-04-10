package image.parsers;

import exceptions.ApplicationException;
import image.images_in_memory.InMemoryImage;
import image.signatures.FormatType;

import java.io.BufferedInputStream;
import java.io.IOException;

import static util.NetbpmFormatHelper.skipCommentsAndWhitespace;

public abstract class NetpbmParser implements ImageParser {
    protected abstract boolean requiresMaxValue();

    public abstract FormatType getSupportedFormat();

    protected abstract InMemoryImage readPixels(BufferedInputStream bis, int width, int height, short maxColor);

    protected int getNextInt(BufferedInputStream bis) {
        skipCommentsAndWhitespace(bis);
        StringBuilder sb = new StringBuilder();

        int b;
        while (true) try {
            boolean isDigit = (b = bis.read()) != -1 && Character.isDigit(b);
            if (!isDigit) break;
            sb.append((char) b);
        } catch (IOException e) {
            throw new ApplicationException("File reading error!", e);
        }

        return !sb.isEmpty() ? Integer.parseInt(sb.toString()) : -1;
    }

    protected String readMagic(BufferedInputStream bis) {
        skipCommentsAndWhitespace(bis);
        try {
            int b1 = bis.read();
            if (b1 != -1 && b1 != 'P') {
                String msg = String.format("Invalid Netpbm header. Expected 'P' (80), but received: '%s' (%d)", (char) b1, b1);
                throw new ApplicationException(msg);
            }

            int b2 = bis.read();
            if (b2 != -1 && (b2 < '1' || b2 > '6')) {
                String msg = String.format("Invalid Netpbm header. Expected '1' (49) - '6' (55), but received: '%s' (%d)", (char) b2, b2);
                throw new ApplicationException(msg);
            }

            return "" + (char) b1 + (char) b2;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InMemoryImage parse(BufferedInputStream bis) {
        String magicNumber = readMagic(bis);

        short width = (short) getNextInt(bis);
        short height = (short) getNextInt(bis);

        short maxColor = 1;
        if (requiresMaxValue())
            maxColor = (short) getNextInt(bis);

        return readPixels(bis, width, height, maxColor);
    }
}
