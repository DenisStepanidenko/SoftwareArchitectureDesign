package homeWorks.finalProject.armyFactory.meleeArmyFactory;

import homeWorks.finalProject.armyFactory.ArmyFactory;
import homeWorks.finalProject.baseUnit.meleeUnit.HeavyUnit;
import homeWorks.finalProject.baseUnit.meleeUnit.LightUnit;
import homeWorks.finalProject.baseUnit.meleeUnit.MeleeUnit;

public class MeleeArmyFactory implements ArmyFactory<MeleeUnit> {

    @Override
    public MeleeUnit create(String typeOfUnit) {
        if ("Light".equalsIgnoreCase(typeOfUnit)) {
            return new LightUnit(1, 50, 1, 0, 5, 0);
        } else if ("Heavy".equalsIgnoreCase(typeOfUnit)) {
            return new HeavyUnit(1, 50, 1, 0, 5, 0);
        }
        return null;
    }
}
