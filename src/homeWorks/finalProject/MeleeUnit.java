package homeWorks.finalProject;

public abstract class MeleeUnit extends Unit implements Melee {

    public MeleeUnit(int healthPoint, int attack, int defense, int cost, int dodge) {
        super(healthPoint, attack, defense, cost, dodge);
    }


    public abstract int generateCriticalDamage();


    @Override
    public void attack(Unit unit) {
        meleeAttack(unit);
    }

    @Override
    public void meleeAttack(Unit unit) {
        // формула для атаки
        int commonDamage = this.getAttack() * generateCriticalDamage() - unit.getDefense() - unit.generatedDodge() * unit.getDodge();
        int currentHp = unit.getHealthPoint();

        unit.setHealthPoint(currentHp - commonDamage);
    }
}
