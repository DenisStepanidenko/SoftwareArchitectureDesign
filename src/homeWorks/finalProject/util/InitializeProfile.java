package homeWorks.finalProject.util;

import homeWorks.finalProject.BuyUnitCommand;
import homeWorks.finalProject.User;
import homeWorks.finalProject.armyFactory.ArmyFactory;
import homeWorks.finalProject.armyFactory.armyFactoryProvider.ArmyFactoryProvider;
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
            int choice = input.getChoiceForBuy(user);
            switch (choice) {
                case 1:
                    // закончить все покупки
                    // нужно проверить, купил ли пользователь хотя бы одного юнита
                    boolean checking = checkForBuying(user);
                    if(checking){
                        // stack юнитов пустой, и нужно попросить пользователя купить >= 1 юнита
                        System.out.println("Купите, пожалуйста, хотя бы одного персонажа");
                        System.out.println();
                        System.out.println("-------------");
                    }
                    else {
                        flag = false;
                        System.out.println();
                        System.out.println("-------------");
                    }
                    break;
                case 2:
                    // покупка юнита
                    buyUnit(user);
                    break;
                case 3:
                    BuyUnitCommand buyUnitCommand = new BuyUnitCommand(user);
                    buyUnitCommand.undo();
                    break;
            }

        }
    }

    private boolean checkForBuying(User user) {
        return user.getAllUnits().isEmpty();
    }

    private void buyUnit(User user) {
        /**
         * Для начала нужно получить тип юнита, который мы хотим купить
         */
        String choiceForTypeUnit = input.getTypeOfUnit();

        /**
         * Теперь создаём соответствующую фабрику
         */
        ArmyFactory factory = ArmyFactoryProvider.getFactory(choiceForTypeUnit);

        /**
         * Теперь нужно попросить у пользователя конкретного юнита для покупки
         */
        String unitForBuy = input.getUnit(choiceForTypeUnit);

        /**
         * Теперь с помощью команды покупаем юнита
         */
        BuyUnitCommand buyUnitCommand = new BuyUnitCommand(user);
        buyUnitCommand.execute((Unit) factory.create(unitForBuy));
    }

}
