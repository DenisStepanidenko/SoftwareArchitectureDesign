package homeWorks.finalProject;

public interface ArmyFactory<T> {
    T create(String typeOfUnit);
}
