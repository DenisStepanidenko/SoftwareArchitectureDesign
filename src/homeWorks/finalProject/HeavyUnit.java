package homeWorks.finalProject;

import java.util.Random;

public class HeavyUnit extends MeleeUnit {

    public HeavyUnit(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge);
    }

    /**
     * Метод, который генерирует шанс уклониться от урона
     * @return возвращает коэффициент
     */
    @Override
    public int generatedDodge() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if(randomNumber <= 15){
            return 1;
        }
        return 0;
    }


    /**
     * Метод, который генерирует шанс нанесения критического урона
     * @return возвращает коэффициент
     */
    @Override
    public int generateCriticalDamageForMeleeAttack() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // генерируем число от 1 до 10
        if (randomNumber <= 25) {
            return 2;
        }
        return 1;
    }

}
