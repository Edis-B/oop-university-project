package util;

import exceptions.ApplicationException;

import java.io.BufferedInputStream;
import java.io.IOException;

public class NetbpmFormatHelper {
    public static boolean skipCommentsAndWhitespace(BufferedInputStream bis) {
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
