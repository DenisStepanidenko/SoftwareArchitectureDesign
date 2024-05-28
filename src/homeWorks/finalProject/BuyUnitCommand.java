package homeWorks.finalProject;

import homeWorks.finalProject.baseUnit.Unit;

import java.util.Stack;

public class BuyUnitCommand implements Command {
    private User user;

    public BuyUnitCommand(User user) {
        this.user = user;
    }

    @Override
    public void execute(Unit unit) {
        if (user.getTotalSumOfMoney() < unit.getCost()) {
            System.out.println("У вас недостаточно денег, чтобы купить данного юнита");
            return;
        }

        int currentSumOfMoney = user.getTotalSumOfMoney();
        user.setTotalSumOfMoney(currentSumOfMoney - unit.getCost());
        Stack<Unit> currentUnitStack = user.getAllUnits();
        currentUnitStack.add(unit);
        System.out.println("Вы успешно купили " + unit.getClass());
    }

    @Override
    public void undo() {
        Stack<Unit> currentUnitStack = user.getAllUnits();
        if (currentUnitStack.isEmpty()) {
            System.out.println("Вы ещё не купили ни одного персонажа");
            return;
        }

        Unit deletedUnit = currentUnitStack.pop();
        int priceOfDeletedUnit = deletedUnit.getCost();

        int currentSumOfMoney = user.getTotalSumOfMoney();
        user.setTotalSumOfMoney(currentSumOfMoney + priceOfDeletedUnit);
        System.out.println("Покупка персонажа " + deletedUnit.getClass() + " успешно отменена");
    }
}
