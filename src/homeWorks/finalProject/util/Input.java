package homeWorks.finalProject.util;

import homeWorks.finalProject.User;
import homeWorks.finalProject.baseUnit.Unit;

import java.util.Scanner;
import java.util.Stack;

public class Input {
    public String getName() {
        while (true) {
            try {
                System.out.println("Для начала игры, введите своё никнейм");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                if (name == null || name.isEmpty()) {
                    throw new Exception();
                }
                System.out.println();
                System.out.println("-------------");
                return name;
            } catch (Exception e) {
                System.out.println("Произошла ошибка, введите имя ещё раз");
                System.out.println();
                System.out.println("-------------");
            }
        }
    }

    public int getChoiceForBuy(User user) {
        while (true) {
            try {
                System.out.println(description(user));
                System.out.println("Выберите действие:");
                System.out.println("1.Закончить покупку");
                System.out.println("2.Купить юнита");
                System.out.println("3.Отменить последнюю покупку");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice != 1 && choice != 2 && choice != 3) {
                    throw new Exception();
                }
                return choice;
            } catch (Exception e) {
                System.out.println("Произошла ошибка, введите выбор ещё раз.");
            }
        }
    }

    private String description(User user) {
        StringBuilder description = new StringBuilder();
        description.append(user.getName()).append(", ваша текущая сумма монет: ").append(user.getTotalSumOfMoney()).append("\n");
        description.append("Текущая армия: ").append("\n");
        description.append(getDescriptionOfArmy(user.getAllUnits()));

        return description.toString();
    }

    private String getDescriptionOfArmy(Stack<Unit> allUnits) {
        StringBuilder description = new StringBuilder();
        for (Unit unit : allUnits) {
            description.append(unit.getClass().getSimpleName()).append(" ");
        }

        if (allUnits.isEmpty()) {
            description.append("У вас пока что нет юнитов в армии.");
        }
        return description.toString();
    }

    public String getTypeOfUnit() {
        while (true) {
            try {
                System.out.println("Какого вида юнита вы хотите купить");
                System.out.println("1.RangeUnit");
                System.out.println("2.MeleeUnit");
                Scanner scanner = new Scanner(System.in);

                int choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    throw new Exception();
                }
                if (choice == 1) {
                    return "RangeUnit";
                }
                return "MeleeUnit";
            } catch (Exception e) {
                System.out.println("Произошла ошибка, введите выбор ещё раз.");
            }

        }
    }


    public String getUnit(String choiceForTypeUnit) {
        if (choiceForTypeUnit.equals("MeleeUnit")) {
            while (true) {
                try {
                    System.out.println("Какого юнита вы хотите купить");
                    System.out.println("1.Light");
                    System.out.println("2.Heavy");
                    Scanner scanner = new Scanner(System.in);

                    int choice = scanner.nextInt();
                    if (choice != 1 && choice != 2) {
                        throw new Exception();
                    }
                    if (choice == 1) {
                        return "Light";
                    }
                    return "Heavy";
                } catch (Exception e) {
                    System.out.println("Произошла ошибка, введите выбор ещё раз.");
                }

            }
        } else {
            while (true) {
                try {
                    System.out.println("Какого юнита вы хотите купить");
                    System.out.println("1.Archer");
                    System.out.println("2.Mage");
                    System.out.println("3.Healer");
                    Scanner scanner = new Scanner(System.in);

                    int choice = scanner.nextInt();
                    if (choice != 1 && choice != 2 && choice != 3) {
                        throw new Exception();
                    }
                    if (choice == 1) {
                        return "Archer";
                    } else if (choice == 2) {
                        return "Mage";
                    }
                    return "Healer";
                } catch (Exception e) {
                    System.out.println("Произошла ошибка, введите выбор ещё раз.");
                }

            }
        }
    }
}
