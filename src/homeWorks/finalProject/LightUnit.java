package homeWorks.finalProject;


import java.util.Random;

public class LightUnit extends MeleeUnit implements Clonable {
    public LightUnit(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge) {
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
        if (randomNumber <= 30) {
            return 1;
        }
        return 0;
    }

    /**
     * Метод, который генерирует шанс нанесения критического урона
     * @return возвращает коэффициент
     */
    public int generateCriticalDamageForMeleeAttack() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // генерируем число от 1 до 10
        if (randomNumber <= 15) {
            return 2;
        }
        return 1;
    }

    public LightUnit(LightUnit target){
        super(target);
    }

    @Override
    public Unit clone() {
        return new LightUnit(this);

    }
}
