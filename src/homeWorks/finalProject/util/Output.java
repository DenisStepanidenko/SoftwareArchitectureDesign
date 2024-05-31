package homeWorks.finalProject.util;

import homeWorks.finalProject.User;
import homeWorks.finalProject.baseUnit.Unit;

import java.util.*;

public class Output {
    public void getToStringForArmy(User firstUser, User secondUser) {
        System.out.println("Текущая ситуация армий (" + firstUser.getName() + "/" + secondUser.getName() + ")");
        System.out.print(getDescription(getToStringForArmy(firstUser)) + "        ");
        List<String> secondUserArmy = getToStringForArmy(secondUser);
        Collections.reverse(secondUserArmy);
        System.out.println(getDescription(secondUserArmy));
        System.out.println();
        System.out.println("-------------");
    }

    private List<String> getToStringForArmy(User user) {
        List<String> description = new LinkedList<>();
        for (Unit unit : user.getAllUnits()) {
            description.add(unit.getClass().getSimpleName() + "(" + unit.getCurrentHealthPoint() + ")");
        }
        return description;
    }

    private String getDescription(List<String> army) {
        StringBuilder builder = new StringBuilder();

        for (String unit : army) {
            builder.append(unit).append(" ");
        }

        return builder.toString();
    }

    public void getInfoAboutKill(User firstUser, User secondUser, Unit unitForFirstUser, Unit unitForSecondUser) {
        System.out.println(unitForFirstUser.getClass().getSimpleName() + " игрока " + firstUser.getName() + " уничтожает " + unitForSecondUser.getClass().getSimpleName() + " игрока " + secondUser.getName());
        System.out.println();
        System.out.println("-------------");

    }

    public void getStartMeleeAttack() {
        System.out.println("Атакуют юниты, которые стоят на первых позициях...");
        System.out.println();
        System.out.println("-------------");
    }

    public void getInfoAboutWinner(String winner) {
        System.out.println("Пользователь " + winner + " одержал победу!");
    }

    public void getInfoAboutAttack(User firstUser, User secondUser, Unit unitForFirstUser, Unit unitForSecondUser) {
        System.out.println(unitForFirstUser.getClass().getSimpleName() + " игрока " + firstUser.getName() + " наносит урон " + unitForSecondUser.getClass().getSimpleName() + " игрока " + secondUser.getName());
        System.out.println();
        System.out.println("-------------");
    }
    public void getInfoAboutCloning(User firstUser, Unit mage, Unit cloned) {
        System.out.println(mage.getClass().getSimpleName() + " игрока " + firstUser.getName() + " клонирует " + cloned.getClass().getSimpleName());
        System.out.println();
        System.out.println("-------------");
    }
    public void getInfoAboutHealing(User firstUser, Unit healer, Unit healed) {
        System.out.println(healer.getClass().getSimpleName() + " игрока " + firstUser.getName() + " лечит " + healed.getClass().getSimpleName());
        System.out.println();
        System.out.println("-------------");
    }

    public void getStartArcherAttack() {
        System.out.println("Атакуют лучники");
        System.out.println();
        System.out.println("-------------");
    }

    public void getStartHealerAct() {
        System.out.println("Ходят хилеры");
        System.out.println();
        System.out.println("-------------");
    }
    public void getStartMageAct() {
        System.out.println("Ходят маги");
        System.out.println();
        System.out.println("-------------");
    }
    public void getInfoAboutAbility(User user, String simpleName) {
        System.out.println(user.getName() + " получил бафф в виде " + simpleName);
    }

}
