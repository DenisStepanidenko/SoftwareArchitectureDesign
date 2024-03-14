package homeWorks.third.abstractFactoryAndFactoryMethod.apple;

import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Laptop;

public class MacBook implements Laptop {
    @Override
    public void showInfo() {
        System.out.println("You have created MacBook.");
    }
}
