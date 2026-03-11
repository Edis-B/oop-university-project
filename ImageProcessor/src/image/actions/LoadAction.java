package image.actions;

import exceptions.ApplicationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadAction extends Action {
    String filePath;

    public LoadAction(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        File imageFile = new File(filePath);
        try (Scanner sc = new Scanner(imageFile)) {
            while (sc.hasNext())
                System.out.println(sc.nextLine());
        } catch (FileNotFoundException e) {
            throw new ApplicationException((String.format("File \"%s\" was not found!", imageFile)), e);
        }
    }
}
