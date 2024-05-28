package homeWorks.finalProject.armyFactory.armyFactoryProvider;

import homeWorks.finalProject.armyFactory.ArmyFactory;
import homeWorks.finalProject.armyFactory.meleeArmyFactory.MeleeArmyFactory;
import homeWorks.finalProject.armyFactory.rangeArmyFactory.RangeArmyFactory;

public class ArmyFactoryProvider {
    public static ArmyFactory getFactory(String typeOfFactory) {
        if ("MeleeUnit".equalsIgnoreCase(typeOfFactory)) {
            return new MeleeArmyFactory();
        } else if ("RangeUnit".equalsIgnoreCase(typeOfFactory)) {
            return new RangeArmyFactory();
        }
        return null;
    }
}
