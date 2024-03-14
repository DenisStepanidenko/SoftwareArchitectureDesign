package homeWorks.third.abstractFactoryAndFactoryMethod.samsung;

import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Laptop;

public class GalaxyBook implements Laptop {
    @Override
    public void showInfo() {
        System.out.println("You have created GalaxyBook.");
    }
}
