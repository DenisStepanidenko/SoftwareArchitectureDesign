package homeWorks.finalProject.buffUnit;

import homeWorks.finalProject.baseUnit.meleeUnit.HeavyUnit;

public class BuffDodgeHeavy extends HeavyUnit {

    public BuffDodgeHeavy(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge);
    }

    @Override
    public int getDodge() {
        System.out.println("Улучшенный уворот");
        return super.getDodge() + 5;
    }
}

