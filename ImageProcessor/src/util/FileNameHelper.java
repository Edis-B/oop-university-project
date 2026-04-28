package util;

public class FileNameHelper {
    public static String incrementFileNumbering(String fileName) {
        int duplicateId = getFileDuplicateId(fileName);

        if (duplicateId == -1) {
            return fileName + " (1)";
        } else {
            int lastDot = fileName.lastIndexOf('.'),
                    lastIndex = fileName.length();

            String withoutExtension = fileName.substring(0, Math.max(0, lastDot - 1)),
                    extension = fileName.substring(Math.min(lastDot + 1, lastIndex), lastIndex);

            int len = String.valueOf(duplicateId).length();

            return withoutExtension.substring(0, withoutExtension.length() - 3 - len) +
                    String.format("(%d).", duplicateId + 1) +
                    extension;
        }
    }

    public static String extractFileName(String fileName) {
        String[] arr = fileName.split("[\\\\/]");
        return arr[arr.length - 1];
    }

    public static int getFileDuplicateId(String fileName) {
        int lastDot = fileName.lastIndexOf('.'), lastIndex = fileName.length() - 1;

        String withoutExtension = fileName.substring(0, Math.max(0, lastDot - 1));

        int[] parenthesis = {withoutExtension.lastIndexOf('('),
                withoutExtension.lastIndexOf(')')};

        if (parenthesis[0] == -1 ||
                parenthesis[1] == -1 ||
                parenthesis[0] >= parenthesis[1])
            return -1;

        String duplicateId = withoutExtension.substring(parenthesis[0], parenthesis[1]);

        try {
            return Integer.parseInt(duplicateId);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
