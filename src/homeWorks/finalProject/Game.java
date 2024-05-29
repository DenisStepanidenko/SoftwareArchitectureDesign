package homeWorks.finalProject;

import homeWorks.finalProject.baseUnit.Unit;
import homeWorks.finalProject.baseUnit.rangeUnit.Archer;
import homeWorks.finalProject.util.InitializeProfile;
import homeWorks.finalProject.util.Input;
import homeWorks.finalProject.util.Output;

import java.util.*;

public class Game {
    private final User firstUser = new User("", 100, new Stack<>());
    private final User secondUser = new User("", 100, new Stack<>());
    private final InitializeProfile initializeProfile = new InitializeProfile(new Input());
    private final Output output = new Output();

    public void start() {
        // инициализация всех персонажей
        initializeProfile.loadData(firstUser);
        initializeProfile.loadData(secondUser);


        // Логика игры

        // Первый этап: атакуют сначала юниты, стоящие на самых ближних позициях
        output.getToStringForArmy(firstUser, secondUser);
        output.getStartMeleeAttack();
        meleeAttack();

        // теперь нужно проверить, есть ли победитель
        String winner = isExistsWinner();
        if (!winner.equals("None")) {
            // есть победитель
            output.getInfoAboutWinner(winner);
            return;
        }

        // После meleeAttack выводим текущее состояние армии
        output.getToStringForArmy(firstUser, secondUser);

        // Второй этап: атакуют лучники
        attackArchers();

    }

    private void attackArchers() {
        // нужно найти каждого лучника из обоих отрядов и произвести урон

        // найдём всех лучников из отряда firstUser, и каждому сопоставить список юнитов, по которым он может ударить в зависимости от своего рэнжа
        Map<Archer, List<Unit>> archerFirstUserListMap = new HashMap<>();
        initializeArchers(archerFirstUserListMap, firstUser, secondUser);

        // теперь нужно производить атаку лучниками первого игрока
    }

    private void initializeArchers(Map<Archer, List<Unit>> archerListMap, User owner, User userAttacked) {
        Stack<Unit> army = owner.getAllUnits();
        for (int i = 0; i < army.size() - 1; i++) {
            if (army.get(i) instanceof Archer) {
                Archer currentArcher = (Archer) army.get(i);

                // теперь нужно для данного archer найти список юнитов, по которым он может стрелять
                int range = currentArcher.getRange();

                range = range - (army.size() - i - 1);
                if (range > 0) {
                    List<Unit> currentUnitListForArcher = new ArrayList<>();
                    for (int j = userAttacked.getAllUnits().size() - 1; j > (userAttacked.getAllUnits().size() - 1) - range; j--) {
                        currentUnitListForArcher.add(userAttacked.getAllUnits().get(j));
                    }
                    archerListMap.put(currentArcher, currentUnitListForArcher);
                }
            }
        }
    }

    private String isExistsWinner() {
        if (firstUser.getAllUnits().isEmpty()) {
            return secondUser.getName();
        } else if (secondUser.getAllUnits().isEmpty()) {
            return firstUser.getName();
        }
        return "None";
    }

    private void meleeAttack() {
        Unit unitForFirstUser = firstUser.getAllUnits().peek();
        Unit unitForSecondUser = secondUser.getAllUnits().peek();

        unitForFirstUser.meleeAttack(unitForSecondUser);
        // теперь нужно проверить, жив ли юнит второго игрока
        if (unitForSecondUser.getCurrentHealthPoint() <= 0) {
            // нужно заканчивать атаку ближникам, выведем информацию, кто кого убил
            output.getInfoAboutKill(firstUser, secondUser, unitForFirstUser, unitForSecondUser);
            secondUser.getAllUnits().pop(); // удаляем юнита, которого мы только что убили
            return;
        }

        // теперь если юнит второго игрока выжил, то он наносит урон юнита первого игрока
        unitForSecondUser.meleeAttack(unitForFirstUser);

        // теперь нужно проверить, жив ли юнит первого игрока
        if (unitForFirstUser.getCurrentHealthPoint() <= 0) {
            output.getInfoAboutKill(secondUser, firstUser, unitForSecondUser, unitForFirstUser);
            firstUser.getAllUnits().pop(); // удаляем юнита, которого мы только что убили
        }
    }


}
