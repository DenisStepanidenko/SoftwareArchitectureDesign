package homeWorks.finalProject.buffUnit;

import homeWorks.finalProject.baseUnit.meleeUnit.HeavyUnit;

public class BuffAttackHeavy extends HeavyUnit {
    public BuffAttackHeavy(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge);
    }

    @Override
    public int getAttack() {
        return super.getAttack() + 3;
    }
}
