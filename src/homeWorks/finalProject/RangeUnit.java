package homeWorks.finalProject;

public abstract class RangeUnit extends Unit implements Range, Melee {
    public RangeUnit(int healthPoint, int attack, int defense, int cost, int dodge) {
        super(healthPoint, attack, defense, cost, dodge);
    }

    @Override
    public void attack(Unit unit) {
        meleeAttack(unit);
    }

    @Override
    public void meleeAttack(Unit unit) {
        // формула для атаки
        int commonDamage = this.getAttack() - unit.getDefense() - unit.generatedDodge() * unit.getDodge();
        int currentHp = unit.getHealthPoint();

        unit.setHealthPoint(currentHp - commonDamage);
    }
}
