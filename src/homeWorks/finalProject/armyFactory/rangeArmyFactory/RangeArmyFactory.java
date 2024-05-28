package homeWorks.finalProject.armyFactory.rangeArmyFactory;

import homeWorks.finalProject.armyFactory.ArmyFactory;
import homeWorks.finalProject.baseUnit.rangeUnit.Archer;
import homeWorks.finalProject.baseUnit.rangeUnit.Healer;
import homeWorks.finalProject.baseUnit.rangeUnit.Mage;
import homeWorks.finalProject.baseUnit.rangeUnit.RangeUnit;

public class RangeArmyFactory implements ArmyFactory<RangeUnit> {

    @Override
    public RangeUnit create(String typeOfUnit) {
        if ("Archer".equalsIgnoreCase(typeOfUnit)) {
            return new Archer(1, 2, 3, 4, 5, 6, 7);
        } else if ("Mage".equalsIgnoreCase(typeOfUnit)) {
            return new Mage(1, 2, 3, 4, 5, 6, 7);
        } else if ("Healer".equalsIgnoreCase(typeOfUnit)) {
            return new Healer(1, 2, 3, 4, 5, 6, 7, 8);
        }
        return null;
    }
}
