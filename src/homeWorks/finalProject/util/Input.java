package homeWorks.finalProject.util;

import java.util.Scanner;

public class Input {
    public String getName() {
        while (true) {
            try {
                System.out.println("Введите своё никнейм");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                if (name == null || name.isEmpty()) {
                    throw new Exception();
                }
                return name;
            } catch (Exception e) {
                System.out.println("Произошла ошибка, введите имя ещё раз");
            }
        }
    }
}
