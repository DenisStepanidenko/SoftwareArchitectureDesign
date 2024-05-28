package homeWorks.finalProject.baseUnit.rangeUnit;

import homeWorks.finalProject.baseUnit.Unit;
import homeWorks.finalProject.baseUnit.meleeUnit.LightUnit;

import java.util.Random;

public class Mage extends RangeUnit {

    public Mage(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge, int range) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge, range);
    }

    @Override
    public Unit rangeAction(Unit unit) {
        if(unit instanceof LightUnit){
            return ((LightUnit) unit).clone();
        }
        return ((Archer) unit).clone();
    }

    @Override
    public int generatedDodge() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber <= 5) {
            return 1;
        }
        return 0;
    }
}
