package homeWorks.finalProject.buffUnit;

import homeWorks.finalProject.baseUnit.meleeUnit.HeavyUnit;

public class BuffDefenseHeavy extends HeavyUnit {

    public BuffDefenseHeavy(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge);
    }

    @Override
    public int getDefense() {
        //System.out.println("Улучшенная защита");
        return super.getDefense() + 5;
    }
}
