package homeWorks.finalProject;

import homeWorks.finalProject.baseUnit.Unit;
import homeWorks.finalProject.baseUnit.meleeUnit.HeavyUnit;
import homeWorks.finalProject.baseUnit.meleeUnit.LightUnit;
import homeWorks.finalProject.baseUnit.rangeUnit.Archer;
import homeWorks.finalProject.baseUnit.rangeUnit.Healer;
import homeWorks.finalProject.baseUnit.rangeUnit.Mage;
import homeWorks.finalProject.buffUnit.BuffAttackHeavy;
import homeWorks.finalProject.buffUnit.BuffDefenseHeavy;
import homeWorks.finalProject.buffUnit.BuffDodgeHeavy;
import homeWorks.finalProject.util.InitializeProfile;
import homeWorks.finalProject.util.Input;
import homeWorks.finalProject.util.Output;

import java.util.*;

public class Game {
    private final User firstUser = new User("", 100, new Stack<>());
    private final User secondUser = new User("", 100, new Stack<>());
    private final InitializeProfile initializeProfile = new InitializeProfile(new Input());
    private final Output output = new Output();

    public void start() throws InterruptedException {
        // инициализация всех персонажей
        initializeProfile.loadData(firstUser);
        initializeProfile.loadData(secondUser);

        checkingForAbility(firstUser);
        checkingForAbility(secondUser);

        output.getToStringForArmy(firstUser, secondUser);
        System.exit(0);
        while (true) {
            // Логика игры
            // нулевой этап : проверяем абилки

            Thread.sleep(7000);
            // Первый этап: атакуют сначала юниты, стоящие на самых ближних позициях
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
            checkingForAbility(firstUser);
            checkingForAbility(secondUser);
            output.getToStringForArmy(firstUser, secondUser);


            Thread.sleep(7000);
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
            // После rangeAttack выводим текущее состояние армии
            checkingForAbility(firstUser);
            checkingForAbility(secondUser);
            output.getToStringForArmy(firstUser, secondUser);

            Thread.sleep(7000);
            //
            output.getStartHealerAct();
            actHealers();

            // После лечения выводим текущее состояние армии
            output.getToStringForArmy(firstUser, secondUser);

            //
            output.getStartMageAct();
            actMages();

            // После клонирования выводим текущее состояние армии
            checkingForAbility(firstUser);
            checkingForAbility(secondUser);
            output.getToStringForArmy(firstUser, secondUser);
        }

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
                Unit buff;
                switch (variant) {
                    case 1:
                        // делаем абилку на атаку
                        buff = new BuffAttackHeavy(units.get(i + 1).getMaxHealth(), units.get(i + 1).getCurrentHealthPoint(), units.get(i + 1).getAttack(), units.get(i + 1).getDefense(), units.get(i + 1).getCost(), units.get(i + 1).getDodge());
                        units.set(i + 1, buff);
                        output.getInfoAboutAbility(user, BuffAttackHeavy.class.getSimpleName());
                        break;
                    case 2:
                        // делаем абилку на защиту
                        buff = new BuffDefenseHeavy(units.get(i + 1).getMaxHealth(), units.get(i + 1).getCurrentHealthPoint(), units.get(i + 1).getAttack(), units.get(i + 1).getDefense(), units.get(i + 1).getCost(), units.get(i + 1).getDodge());
                        units.set(i + 1, buff);
                        output.getInfoAboutAbility(user, BuffDefenseHeavy.class.getSimpleName());
                        break;
                    case 3:
                        // делаем абилку на уклонение
                        buff = new BuffDodgeHeavy(units.get(i + 1).getMaxHealth(), units.get(i + 1).getCurrentHealthPoint(), units.get(i + 1).getAttack(), units.get(i + 1).getDefense(), units.get(i + 1).getCost(), units.get(i + 1).getDodge());
                        units.set(i + 1, buff);
                        output.getInfoAboutAbility(user, BuffDodgeHeavy.class.getSimpleName());
                        break;
                }

            }
        }

    }


    private void actHealers() throws InterruptedException {
        // нужно найти каждого хиллера из обоих отрядов и произвести лечение

        // найдём всех хиллеров из отряда firstUser, и каждому сопоставим список юнитов, которых он может полечить в зависимости от своего рэнжа
        Map<Healer, List<Unit>> healerFirstUserListMap = new HashMap<>();
        initializeHealers(healerFirstUserListMap, firstUser);

        // теперь нужно производить лечение хиллерами первого игрока
        initializeHealersAction(healerFirstUserListMap, firstUser);

        Thread.sleep(1000);

        // найдём всех хиллеров из отряда secondUser, и каждому сопоставим список юнитов, которых он может полечить в зависимости от своего рэнжа
        Map<Healer, List<Unit>> healerSecondUserListMap = new HashMap<>();
        initializeHealers(healerSecondUserListMap, secondUser);

        // теперь нужно производить лечение хиллерами второго игрока
        initializeHealersAction(healerSecondUserListMap, secondUser);
    }

    private void actMages() throws InterruptedException {
        // нужно найти каждого мага из обоих отрядов и произвести клонирование

        // найдём всех магов из отряда firstUser, и каждому сопоставим список юнитов, которых он может клонировать в зависимости от своего рэнжа
        Map<Mage, List<Unit>> mageFirstUserListMap = new HashMap<>();
        initializeMages(mageFirstUserListMap, firstUser);

        // теперь нужно производить клонирование магами первого игрока
        initializeMagesAction(mageFirstUserListMap, firstUser);

        Thread.sleep(1000);

        // найдём всех магов из отряда secondUser, и каждому сопоставим список юнитов, которых он может клонировать в зависимости от своего рэнжа
        Map<Mage, List<Unit>> mageSecondUserListMap = new HashMap<>();
        initializeMages(mageSecondUserListMap, secondUser);

        // теперь нужно производить клонирование магами второго игрока
        initializeMagesAction(mageSecondUserListMap, secondUser);
    }

    private void attackArchers() throws InterruptedException {
        // нужно найти каждого лучника из обоих отрядов и произвести урон

        // найдём всех лучников из отряда firstUser, и каждому сопоставим список юнитов, по которым он может ударить в зависимости от своего рэнжа
        Map<Archer, List<Unit>> archerFirstUserListMap = new HashMap<>();
        initializeArchers(archerFirstUserListMap, firstUser, secondUser);

        // теперь нужно производить атаку лучниками первого игрока
        initializeArchersAttack(archerFirstUserListMap, firstUser, secondUser);

        Thread.sleep(1000);

        // найдём всех лучников из отряда secondUser, и каждому сопоставим список юнитов, по которым он может ударить в зависимости от своего рэнж
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
                // выводим сообщение о том, что лучник убил юнита
                output.getInfoAboutKill(owner, userAttacked, archer, units.get(index));

                // мы должны его удалить из стека

                // удаляем его из стека юнитов
                userAttacked.getAllUnits().remove(units.get(index));

                // далее мы его должны удалить из списка юнитов всех лучников
                deleteArcher(archers, units.get(index));
            }
        }
    }

    private void initializeHealersAction(Map<Healer, List<Unit>> healers, User owner) {
        for (Map.Entry<Healer, List<Unit>> entry : healers.entrySet()) {
            Healer healer = entry.getKey();
            List<Unit> units = entry.getValue();
            if (units.isEmpty()) {
                continue;
            }
            // теперь нужно полечить рандомного юнита
            Random random = new Random();
            int index = random.nextInt(units.size());
            healer.rangeAction(units.get(index));

            // выводим сообщение о том, что было произведено лечение
            output.getInfoAboutHealing(owner, healer, units.get(index));

        }
    }

    private void initializeMagesAction(Map<Mage, List<Unit>> mages, User owner) {
        for (Map.Entry<Mage, List<Unit>> entry : mages.entrySet()) {
            Mage mage = entry.getKey();
            List<Unit> units = entry.getValue();
            if (units.isEmpty()) {
                continue;
            }
            // теперь нужно клонировать рандомного юнита
            Random random = new Random();
            int index = random.nextInt(units.size());
            Unit unit = mage.rangeAction(units.get(index));
            owner.getAllUnits().add(unit);

            // выводим сообщение о том, что было произведено клонирование
            output.getInfoAboutCloning(owner, mage, units.get(index));

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

    private void initializeHealers(Map<Healer, List<Unit>> healerListMap, User owner) {
        Stack<Unit> army = owner.getAllUnits();
        for (int i = 0; i < army.size() - 1; i++) {
            if (army.get(i) instanceof Healer) {
                Healer currentHealer = (Healer) army.get(i);

                // теперь нужно для данного healer найти список юнитов, которых он может полечить
                int range = currentHealer.getRange();


                List<Unit> currentUnitListForHealer = new ArrayList<>();
                for (int j = i - range; (j < i) && (j >= 0); j++) {
                    // Нужна проверка, что юнит не является Гуляй-городом и что он ранен
                    if (army.get(j).getCurrentHealthPoint() < army.get(j).getMaxHealth()) {
                        currentUnitListForHealer.add(army.get(j));
                    }
                }

                for (int k = i + 1; (k <= i + range) && (k < army.size()); k++) {
                    // Нужна проверка, что юнит не является Гуляй-городом и что он ранен
                    if (army.get(k).getCurrentHealthPoint() < army.get(k).getMaxHealth()) {
                        currentUnitListForHealer.add(army.get(k));
                    }
                }
                healerListMap.put(currentHealer, currentUnitListForHealer);

            }
        }
    }

    private void initializeMages(Map<Mage, List<Unit>> mageListMap, User owner) {
        Stack<Unit> army = owner.getAllUnits();
        for (int i = 0; i < army.size() - 1; i++) {
            if (army.get(i) instanceof Mage) {
                Mage currentMage = (Mage) army.get(i);

                // теперь нужно для данного mage найти список юнитов, которых он может клонировать
                int range = currentMage.getRange();


                List<Unit> currentUnitListForMage = new ArrayList<>();
                for (int j = i - range; (j < i) && (j >= 0); j++) {
                    // Нужна проверка, что юнита можно клонировать
                    if (army.get(j) instanceof LightUnit || army.get(j) instanceof Archer)
                        currentUnitListForMage.add(army.get(j));
                }

                for (int k = i + 1; (k <= i + range) && (k < army.size()); k++) {
                    // Нужна проверка, что юнита можно клонировать
                    if (army.get(k) instanceof LightUnit || army.get(k) instanceof Archer)
                        currentUnitListForMage.add(army.get(k));
                }

                mageListMap.put(currentMage, currentUnitListForMage);

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

    private void meleeAttack() throws InterruptedException {
        Unit unitForFirstUser = firstUser.getAllUnits().peek();
        Unit unitForSecondUser = secondUser.getAllUnits().peek();

        unitForFirstUser.meleeAttack(unitForSecondUser);
        output.getInfoAboutAttack(firstUser, secondUser, unitForFirstUser, unitForSecondUser);
        Thread.sleep(1000);
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