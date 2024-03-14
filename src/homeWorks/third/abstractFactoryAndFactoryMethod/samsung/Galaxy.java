package homeWorks.third.abstractFactoryAndFactoryMethod.samsung;

import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Smartphone;

public class Galaxy implements Smartphone {
    @Override
    public void showInfo() {
        System.out.println("You have created Galaxy.");
    }
}
