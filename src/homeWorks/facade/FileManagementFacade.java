package homeWorks.facade;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagementFacade {
    private final String pathToRootFolder = "src/homeWorks/facade/folders";

    public String getPathToRootFolder() {
        return pathToRootFolder;
    }



    public void createFolder(String path, String nameOfFolder) {
        File folder = new File(path);
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Папка с именем " + nameOfFolder + " успешно создана");
            } else {
                System.out.println("Произошла ошибка при создании папки");
            }
        } else {
            System.out.println("Папка с именем " + nameOfFolder + " уже существует");
        }
    }

    public void deleteFile(String path) {
        File file = new File(path);
        if (file.delete()) {
            System.out.println("Файл с именем " + new File(path).getName() + " была успешно удалена");
        } else {
            System.out.println("Произошла ошибка при удалении файла с именем " + new File(path).getName());
        }
    }
}
