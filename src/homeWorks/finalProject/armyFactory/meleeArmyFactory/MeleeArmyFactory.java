package homeWorks.finalProject.armyFactory.meleeArmyFactory;

import homeWorks.finalProject.armyFactory.ArmyFactory;
import homeWorks.finalProject.baseUnit.meleeUnit.HeavyUnit;
import homeWorks.finalProject.baseUnit.meleeUnit.LightUnit;
import homeWorks.finalProject.baseUnit.meleeUnit.MeleeUnit;

public class MeleeArmyFactory implements ArmyFactory<MeleeUnit> {

    @Override
    public MeleeUnit create(String typeOfUnit) {
        if ("Light".equalsIgnoreCase(typeOfUnit)) {
            return new LightUnit(5, 5, 3, 1, 4, 2);
        } else if ("Heavy".equalsIgnoreCase(typeOfUnit)) {
            return new HeavyUnit(8, 8, 5, 2, 12, 1);
        }
        return null;
    }
}
