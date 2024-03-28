package homeWorks.third.abstractFactoryAndFactoryMethod.apple;

import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Pad;

public class IPad implements Pad {
    @Override
    public void showInfo() {
        System.out.println("You have created IPad.");
    }
}
