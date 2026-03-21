package image.parsers;

import exceptions.ApplicationException;

import java.io.BufferedInputStream;
import java.io.IOException;

public abstract class NetpbmParser implements ImageParser {
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

        return Integer.parseInt(sb.toString());
    }

    protected String readMagic(BufferedInputStream bis) {
        skipCommentsAndWhitespace(bis);
        try {
            int b1 = bis.read();
            if (b1 != -1 && b1 != 'P') {
                String msg = String.format("Invalid Netpbm header. Expected 'P' (80), but received: %d ('%s')", b1, (char)b1);
                throw new ApplicationException(msg);
            }

            int b2 = bis.read();
            if (b2 != -1 && (b2 < '1' || b2 > '6')) {
                String msg = String.format("Invalid Netpbm header. Expected '1' (49) - '6' (55), but received: %d ('%s')", b2, (char)b2);
                throw new ApplicationException(msg);
            }

            return "" + (char)b1 + (char) b2;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean skipCommentsAndWhitespace(BufferedInputStream bis) {
        int b;
        while (true) try {
            bis.mark(1);
            b = bis.read();
            if (b == -1) return false;

            if (Character.isWhitespace(b)) {
                continue;
            } else if (b == '#') {
                while ((b = bis.read()) != -1 && b != '\n' && b != '\r') ;
            } else {
                bis.reset();
                break;
            }
        } catch (IOException e) {
            throw new ApplicationException("File reading error!", e);
        }

        return true;
    }
}
