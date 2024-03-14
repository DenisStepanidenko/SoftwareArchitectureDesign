package homeWorks.third.abstractFactoryAndFactoryMethod.samsung;

import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Pad;

public class GalaxyTab implements Pad {
    @Override
    public void showInfo() {
        System.out.println("You have created GalaxyTab.");
    }
}
