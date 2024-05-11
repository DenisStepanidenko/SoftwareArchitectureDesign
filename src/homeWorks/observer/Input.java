package homeWorks.observer;

import java.util.Scanner;

public class Input {
    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите операцию, которую вы хотите выполнить");
                System.out.println("1 - добавить нового клиента в оповещения");
                System.out.println("2 - удалить какого-то клиента из оповещений");
                System.out.println("3 - добавить новый продукт");
                System.out.println("4 - выйти");
                int choice = scanner.nextInt();

                if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                    throw new Exception();
                }

                return choice;
            } catch (Exception e) {
                System.out.println("Повторите ввод");
            }
        }
    }

    public String getName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя нового клиента для оповещений");

        return scanner.nextLine();
    }

    public String getNameOfProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название нового продукта");

        return scanner.nextLine();
    }

    public double getPrice() {
        Scanner scanner = new Scanner(System.in);

        while(true){
            try{
                System.out.println("Введите новую цену для продукта");
                double price = scanner.nextDouble();
                return price;
            }catch (Exception e){
                System.out.println("Повторите ввод");
            }
        }
    }
}
