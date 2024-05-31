package homeWorks.finalProject;

import homeWorks.finalProject.baseUnit.Unit;
import homeWorks.finalProject.baseUnit.meleeUnit.HeavyUnit;
import homeWorks.finalProject.baseUnit.meleeUnit.LightUnit;
import homeWorks.finalProject.baseUnit.rangeUnit.Archer;
import homeWorks.finalProject.baseUnit.rangeUnit.Mage;
import homeWorks.finalProject.buffUnit.BuffAttackHeavy;
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
        // нулевой этап : проверяем абилки


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
        output.getStartArcherAttack();
        attackArchers();

        // теперь нужно проверить, есть ли победитель
        winner = isExistsWinner();
        if (!winner.equals("None")) {
            // есть победитель
            output.getInfoAboutWinner(winner);
            return;
        }
        // После meleeAttack выводим текущее состояние армии
        output.getToStringForArmy(firstUser, secondUser);




    }

    private void checkingForAbility(User user) {
        Stack<Unit> units = user.getAllUnits();
        // мы должны проверить армию user на возможное наличие buff
        for (int i = 0; i < units.size() - 1; i++) {
            if ((units.get(i) instanceof LightUnit) && (units.get(i + 1) instanceof HeavyUnit)) {
                // мы должны units.get(i+1) сделать абилку
                Random random = new Random();

                // генерируем абилку, для этого генерируем рандомное число от 1 до 3
                int variant = random.nextInt(3) + 1;

                switch (variant){
                    case 1:
                        // делаем абилку на атаку
                        Unit unit = units.get(i + 1);
                        unit = new BuffAttackHeavy(unit.getMaxHealth() , unit.getCurrentHealthPoint() , unit.getAttack() , unit.getDefense() , unit.getCost() , unit.getDodge());
                        //output.getInfoAboutAbility(user , BuffAttackHeavy.);
                }
            }
        }

    }

    private void attackArchers() {
        // нужно найти каждого лучника из обоих отрядов и произвести урон

        // найдём всех лучников из отряда firstUser, и каждому сопоставить список юнитов, по которым он может ударить в зависимости от своего рэнжа
        Map<Archer, List<Unit>> archerFirstUserListMap = new HashMap<>();
        initializeArchers(archerFirstUserListMap, firstUser, secondUser);

        // теперь нужно производить атаку лучниками первого игрока
        initializeArchersAttack(archerFirstUserListMap, firstUser, secondUser);


        // найдём всех лучников из отряда secondUser, и каждому сопоставить список юнитов, по которым он может ударить в зависимости от своего рэнж
        Map<Archer, List<Unit>> archerSecondUserListMap = new HashMap<>();
        initializeArchers(archerSecondUserListMap, secondUser, firstUser);

        // теперь нужно производить атаку лучниками второго игрока
        initializeArchersAttack(archerSecondUserListMap, secondUser, firstUser);
    }

    private void initializeArchersAttack(Map<Archer, List<Unit>> archers, User owner, User userAttacked) {
        for (Map.Entry<Archer, List<Unit>> entry : archers.entrySet()) {
            Archer archer = entry.getKey();
            List<Unit> units = entry.getValue();
            if (units.isEmpty()) {
                continue;
            }
            // теперь нужно выстрелить из лука в рандомного юнита
            Random random = new Random();
            int index = random.nextInt(units.size());
            archer.rangeAction(units.get(index));

            // выводим сообщение о том, что была произведена атака лучником
            output.getInfoAboutAttack(owner, userAttacked, archer, units.get(index));


            // теперь нужно проверить, убили ли мы его
            if (units.get(index).getCurrentHealthPoint() <= 0) {
                // мы должны его удалить из стека

                // удаляем его из стека юнитов
                userAttacked.getAllUnits().remove(units.get(index));

                // далее мы его должны удалить из списка юнитов всех лучников
                deleteArcher(archers, units.get(index));
            }
        }
    }

    private void deleteArcher(Map<Archer, List<Unit>> archers, Unit unit) {
        for (Map.Entry<Archer, List<Unit>> entry : archers.entrySet()) {
            List<Unit> unitList = entry.getValue();
            unitList.remove(unit);
        }
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
                    for (int j = userAttacked.getAllUnits().size() - 1; (j > (userAttacked.getAllUnits().size() - 1) - range) && j >= 0; j--) {
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
        output.getInfoAboutAttack(firstUser, secondUser, unitForFirstUser, unitForSecondUser);
        // теперь нужно проверить, жив ли юнит второго игрока
        if (unitForSecondUser.getCurrentHealthPoint() <= 0) {
            // нужно заканчивать атаку ближникам, выведем информацию, кто кого убил
            output.getInfoAboutKill(firstUser, secondUser, unitForFirstUser, unitForSecondUser);
            secondUser.getAllUnits().pop(); // удаляем юнита, которого мы только что убили
            return;
        }

        // теперь если юнит второго игрока выжил, то он наносит урон юнита первого игрока
        unitForSecondUser.meleeAttack(unitForFirstUser);
        output.getInfoAboutAttack(secondUser, firstUser, unitForSecondUser, unitForFirstUser);
        // теперь нужно проверить, жив ли юнит первого игрока
        if (unitForFirstUser.getCurrentHealthPoint() <= 0) {
            output.getInfoAboutKill(secondUser, firstUser, unitForSecondUser, unitForFirstUser);
            firstUser.getAllUnits().pop(); // удаляем юнита, которого мы только что убили
        }
    }


}
