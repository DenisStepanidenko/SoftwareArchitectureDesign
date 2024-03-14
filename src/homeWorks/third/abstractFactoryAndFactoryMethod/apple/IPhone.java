package homeWorks.third.abstractFactoryAndFactoryMethod.apple;

import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Smartphone;

public class IPhone implements Smartphone {

    @Override
    public void showInfo() {
        System.out.println("You have created IPhone.");
    }
}
