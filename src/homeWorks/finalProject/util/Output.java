package homeWorks.finalProject.util;

import homeWorks.finalProject.User;
import homeWorks.finalProject.baseUnit.Unit;

import java.util.*;

public class Output {
    public String getToStringForArmy(User firstUser, User secondUser) {
        StringBuilder builder = new StringBuilder();
        builder.append("Текущая ситуация армий (" + firstUser.getName() + "/" + secondUser.getName() + ")");
        builder.append("\n");
        builder.append(getDescription(getToStringForArmy(firstUser)) + "        ");
        List<String> secondUserArmy = getToStringForArmy(secondUser);
        Collections.reverse(secondUserArmy);
        builder.append(getDescription(secondUserArmy));
        builder.append("\n");
        builder.append("-------------");


        return builder.toString();
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


    public String getInfoAboutKill(User firstUser, User secondUser, Unit unitForFirstUser, Unit unitForSecondUser) {
        StringBuilder builder = new StringBuilder();
        builder.append(unitForFirstUser.getClass().getSimpleName() + " игрока " + firstUser.getName() + " уничтожает " + unitForSecondUser.getClass().getSimpleName() + " игрока " + secondUser.getName());
        builder.append("\n");
        builder.append("-------------");
        return builder.toString();

    }

    public String getStartMeleeAttack() {
        StringBuilder builder = new StringBuilder();
        builder.append("Атакуют юниты, которые стоят на первых позициях...");
        builder.append("\n");
        builder.append("-------------");



        return builder.toString();
    }

    public String getInfoAboutWinner(String winner) {
        StringBuilder builder = new StringBuilder();
        builder.append("Пользователь " + winner + " одержал победу!");

        return builder.toString();
    }

    public String getInfoAboutAttack(User firstUser, User secondUser, Unit unitForFirstUser, Unit unitForSecondUser) {
        StringBuilder builder = new StringBuilder();
        builder.append(unitForFirstUser.getClass().getSimpleName() + " игрока " + firstUser.getName() + " наносит урон " + unitForSecondUser.getClass().getSimpleName() + " игрока " + secondUser.getName());
        builder.append("\n");
        builder.append("-------------");



        return builder.toString();
    }

    public String getInfoAboutCloning(User firstUser, Unit mage, Unit cloned) {
        StringBuilder builder = new StringBuilder();
        builder.append(mage.getClass().getSimpleName() + " игрока " + firstUser.getName() + " клонирует " + cloned.getClass().getSimpleName());
        builder.append("\n");
        builder.append("-------------");




        return builder.toString();
    }

    public String getInfoAboutHealing(User firstUser, Unit healer, Unit healed) {
        StringBuilder builder = new StringBuilder();
        builder.append(healer.getClass().getSimpleName() + " игрока " + firstUser.getName() + " лечит " + healed.getClass().getSimpleName());
        builder.append("\n");
        builder.append("-------------");



        return builder.toString();
    }

    public String getStartArcherAttack() {
        StringBuilder builder = new StringBuilder();
        builder.append("Атакуют лучники");
        builder.append("\n");
        builder.append("-------------");



        return builder.toString();
    }

    public String getStartHealerAct() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ходят хилеры");
        builder.append("\n");
        builder.append("-------------");



        return builder.toString();
    }

    public String getStartMageAct() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ходят маги");
        builder.append("\n");
        builder.append("-------------");


        return builder.toString();
    }

    public String getInfoAboutAbility(User user, String simpleName) {
        StringBuilder builder = new StringBuilder();
        builder.append(user.getName() + " получил бафф в виде " + simpleName);



        return builder.toString();

    }

}
