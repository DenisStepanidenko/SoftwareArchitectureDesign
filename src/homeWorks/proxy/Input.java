package homeWorks.proxy;

import java.util.Map;
import java.util.Scanner;

public class Input {
    public int getChoiceForFile(Map<Integer, String> allPathes) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("----------");
                System.out.println("Выберите один из файлов");
                for (Map.Entry<Integer, String> entry : allPathes.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
                System.out.println("----------");
                int answer = Integer.parseInt(scanner.nextLine());
                if (!allPathes.containsKey(answer)) {
                    throw new Exception();
                }
                return answer;
            } catch (Exception e) {
                System.out.println("Некорректный ввод, попробуйте ввести заново свой ответ");
            }
        }
    }

    public int getChoiceForOperation() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("----------");
                System.out.println("Выберите одну из операций");
                System.out.println("1 - read");
                System.out.println("2 - write");
                System.out.println("----------");
                int answer = Integer.parseInt(scanner.nextLine());
                if (answer != 1 && answer != 2) {
                    throw new Exception();
                }
                return answer;
            } catch (Exception e) {
                System.out.println("Некорректный ввод, попробуйте ввести заново свой ответ");
            }
        }
    }

    public String getLineToRead() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("----------");
                System.out.println("Введите строку для записи в файл");
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Некорректный ввод, попробуйте ввести заново свой ответ");
            }
        }
    }
}
