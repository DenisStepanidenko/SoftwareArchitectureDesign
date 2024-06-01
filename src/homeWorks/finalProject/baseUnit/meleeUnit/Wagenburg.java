package homeWorks.finalProject.baseUnit.meleeUnit;

public class Wagenburg extends MeleeUnit{
    public Wagenburg(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge);
    }

    @Override
    public int generatedDodge() {
        return 0;
    }

    @Override
    public int generateCriticalDamageForMeleeAttack() {
        return 0;
    }
}
