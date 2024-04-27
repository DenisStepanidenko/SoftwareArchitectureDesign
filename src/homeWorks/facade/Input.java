package homeWorks.facade;

import java.util.Map;
import java.util.Scanner;

public class Input {
    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Выберите нужный функционал");
                System.out.println("1 - Создать папку");
                System.out.println("2 - Удалить файл");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2) {
                    throw new Exception();
                }
                return choice;
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных, повторите ещё раз");
            }
        }
    }

    public String getChoiceForFolder(Map<Integer, String> allPathes) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Выберите в какой из папок вы бы хотели создать свою папку");
                for (Map.Entry<Integer, String> entry : allPathes.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
                int choice = scanner.nextInt();
                if (!allPathes.containsKey(choice)) {
                    throw new Exception();
                }
                return allPathes.get(choice);
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных, повторите ещё раз");
            }
        }
    }

    public String getNameOfFolder() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите название папки");
                return scanner.nextLine();

            } catch (Exception e) {
                System.out.println("Произошла ошибка!");
            }
        }
    }

    public String getPathFiletoDelete(Map<Integer, String> allFiles) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Выберите путь файла, который хотите удалить");
                for (Map.Entry<Integer, String> entry : allFiles.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
                int choice = scanner.nextInt();
                if (!allFiles.containsKey(choice)) {
                    throw new Exception();
                }
                return allFiles.get(choice);
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных, повторите ещё раз");
            }
        }
    }
}
