package homeWorks.command;

import java.util.Scanner;

public class Input {
    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите операцию, которую вы хотите сделать");
                System.out.println("1 - создать файл (txt) , 2 - удалить файл (txt), 3 - выйти");

                int choice = scanner.nextInt();
                if (choice != 1 && choice != 2 && choice != 3) {
                    throw new Exception();
                }
                return choice;
            } catch (Exception e) {
                System.out.println("Повторите попытку ввода ещё раз");
            }
        }
    }

    public String getFileName() {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        System.out.println("Введите имя для файла");
        fileName = scanner.nextLine();
        return fileName;
    }
}
