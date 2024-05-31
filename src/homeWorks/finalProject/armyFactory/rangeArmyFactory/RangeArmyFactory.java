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
            return new Archer(5, 5, 2, 0, 12, 3, 4, 4);
        } else if ("Mage".equalsIgnoreCase(typeOfUnit)) {
            return new Mage(3, 3, 2, 0, 16, 3, 1);
        } else if ("Healer".equalsIgnoreCase(typeOfUnit)) {
            return new Healer(4, 4, 2, 0, 16, 3, 2, 2);
        }
        return null;
    }
}
