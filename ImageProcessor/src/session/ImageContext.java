package session;

import image.images_in_memory.InMemoryImage;
import util.FileNameHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageContext {
    private final List<ImageWrapper> imageArray = new ArrayList<>();
    private final Map<String, ImageWrapper> nameMap = new HashMap<>();

    public ImageContext() {
    }

    public ImageContext(ImageContext old) {
        ((ArrayList<ImageWrapper>) imageArray).ensureCapacity(old.getImageWrapperCount());

        for (ImageWrapper oldWrapper : old.getImageWrapperArray()) {
            ImageWrapper newWrapper = new ImageWrapper(oldWrapper);
            imageArray.add(newWrapper);
            nameMap.put(newWrapper.getName(), newWrapper);
        }
    }

    public String insertImage(InMemoryImage image, String filePath) {
        String fileName = FileNameHelper.extractFileName(filePath);

        while (nameMap.containsKey(fileName)) {
            fileName = FileNameHelper.incrementFileNumbering(fileName);
        }

        ImageWrapper newWrapper = new ImageWrapper(
                image, filePath, fileName
        );

        imageArray.add(newWrapper);
        nameMap.put(fileName, newWrapper);

        return fileName;
    }

    public void insertWrapper(ImageWrapper imageWrapper) {
        imageArray.add(imageWrapper);
        nameMap.put(imageWrapper.getName(), imageWrapper);
    }

    public int getImageWrapperCount() {
        return imageArray.size();
    }

    public List<ImageWrapper> getImageWrapperArray() {
        return imageArray;
    }

    public ImageWrapper getImageWrapperByName(String name) {
        return nameMap.get(name);
    }
}
