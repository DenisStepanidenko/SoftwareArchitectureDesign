package homeWorks.finalProject.util;

import homeWorks.finalProject.User;
import homeWorks.finalProject.baseUnit.Unit;

import java.util.Stack;

public class InitializeProfile {
    private final Input input;

    public InitializeProfile(Input input) {
        this.input = input;
    }

    public void loadData(User user) {
        /**
         * Вначале нужно спросить имя пользователя
         */
        String name = input.getName();
        user.setName(name);


        /**
         * Теперь самое интересное, покупка юнитов
         */
        boolean flag = true;
        while (flag) {
            System.out.println("Ваше текущая сумма монет: " + user.getTotalSumOfMoney());
            System.out.println("Ваша текущая армия: ");
            System.out.println(getDescriptionOfArmy(user.getAllUnits()));

            System.out.println("Для покупки ");
        }
    }

    private String getDescriptionOfArmy(Stack<Unit> allUnits) {
        StringBuilder description = new StringBuilder();
        for (Unit unit : allUnits) {
            description.append(unit.getClass().getSimpleName()).append("\n");
        }

        return description.toString();
    }
}
