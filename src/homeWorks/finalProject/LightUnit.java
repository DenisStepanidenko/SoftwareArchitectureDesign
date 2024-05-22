package homeWorks.finalProject;


import java.util.Random;

public class LightUnit extends MeleeUnit {
    public LightUnit(int healthPoint, int attack, int defense, int cost, int dodge) {
        super(healthPoint, attack, defense, cost, dodge);
    }



    @Override
    public int generatedDodge() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if(randomNumber == 49 || randomNumber == 5){
            return 1;
        }
        return 0;
    }

    @Override
    public int generateCriticalDamage() {
        System.out.println("Light");
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // генерируем число от 1 до 10
        if (randomNumber == 5) {
            return 2;
        }
        return 1;
    }

}
