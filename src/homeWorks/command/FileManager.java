package homeWorks.command;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private final String pathToFile = "src/homeWorks/command/files";

    public void createFile(String fileName) {
        fileName = fileName + ".txt";
        File file = new File(pathToFile + "/" + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getName());
            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при создании файла");
        }
    }

    public void deleteFile(String fileName) {
        fileName = fileName + ".txt";
        File file = new File(pathToFile + "/" + fileName);

        if (file.delete()) {
            System.out.println("Файл успешно удален.");
        } else {
            System.out.println("Не удалось удалить файл.");
        }
    }
}
