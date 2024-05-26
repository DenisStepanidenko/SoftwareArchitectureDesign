package homeWorks.finalProject;

public class RangeUnitFactory implements ArmyFactory<RangeUnit> {

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
