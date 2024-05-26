package homeWorks.finalProject;

public class MeleeArmyFactory implements ArmyFactory<MeleeUnit> {

    @Override
    public MeleeUnit create(String typeOfUnit) {
        if ("Light".equalsIgnoreCase(typeOfUnit)) {
            return new LightUnit(1, 2, 3, 4, 5, 6);
        } else if ("Heavy".equalsIgnoreCase(typeOfUnit)) {
            return new HeavyUnit(1, 2, 3, 4, 5, 6);
        }
        return null;
    }
}
