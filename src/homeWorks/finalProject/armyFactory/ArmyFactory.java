package homeWorks.finalProject.armyFactory;

public interface ArmyFactory<T> {
    T create(String typeOfUnit);
}
