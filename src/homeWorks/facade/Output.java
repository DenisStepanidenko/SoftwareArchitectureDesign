package homeWorks.facade;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Output {
    private FileManagementFacade managementFacade;
    private Input input;


    public Output(FileManagementFacade managementFacade, Input input) {
        this.managementFacade = managementFacade;
        this.input = input;
    }

    public void doOperation(int answer) {
        switch (answer) {
            case 1:
                // здесь должны создать папку, но нужно сначала показать пользователю пути всех директорий
                Map<Integer, String> allPathes = new HashMap<>();
                allPathes.put(1, managementFacade.getPathToRootFolder());
                showAllPathesOfDirectory(allPathes, new File(managementFacade.getPathToRootFolder()), 2);
                if (allPathes.isEmpty()) {
                    String nameOfFolder = input.getNameOfFolder();
                    managementFacade.createFolder(managementFacade.getPathToRootFolder() + "\\" + nameOfFolder, nameOfFolder);
                } else {
                    String choiceOfFolder = input.getChoiceForFolder(allPathes);
                    String nameOfFolder = input.getNameOfFolder();
                    managementFacade.createFolder(choiceOfFolder + "\\" + nameOfFolder, nameOfFolder);
                }
                break;
            case 2:
                // здесь мы должны предложить удалить файл какой-нибудь пользователю
                Map<Integer, String> allFiles = new HashMap<>();
                showAllFiles(allFiles, new File(managementFacade.getPathToRootFolder()), 1);
                if (allFiles.isEmpty()) {
                    System.out.println("Файлов для удаления нет");
                } else {
                    String pathToFileDelete = input.getPathFiletoDelete(allFiles);
                    managementFacade.deleteFile(pathToFileDelete);
                }
                break;
        }
    }

    private void showAllFiles(Map<Integer, String> allFiles, File directory, int count) {
        if (directory.exists() && directory.isDirectory()) {
            File[] subFiles = directory.listFiles(File::isFile);
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    allFiles.put(count, subFile.getAbsolutePath());
                    count++;
                }
            }

            File[] subDirectories = directory.listFiles(File::isDirectory);
            if (subDirectories != null) {
                for (File subdirectory : subDirectories) {
                    showAllFiles(allFiles, subdirectory, count);
                }
            }
        }
    }

    private void showAllPathesOfDirectory(Map<Integer, String> allPathes, File directory, int count) {
        if (directory.exists() && directory.isDirectory()) {
            File[] subDirectories = directory.listFiles(File::isDirectory);
            if (subDirectories != null) {
                for (File subdirectory : subDirectories) {
                    allPathes.put(count, subdirectory.getAbsolutePath());
                    count++;
                    showAllPathesOfDirectory(allPathes, subdirectory, count);
                }
            }
        }

    }
}
