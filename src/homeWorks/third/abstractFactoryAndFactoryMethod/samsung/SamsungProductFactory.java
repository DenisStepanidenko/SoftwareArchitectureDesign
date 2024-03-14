package homeWorks.third.abstractFactoryAndFactoryMethod.samsung;

import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.ElectronicProductFactory;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Laptop;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Pad;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Smartphone;

public class SamsungProductFactory implements ElectronicProductFactory {

    @Override
    public Smartphone createSmartphone() {
        return new Galaxy();
    }

    @Override
    public Laptop createLaptop() {
        return new GalaxyBook();
    }

    @Override
    public Pad createPad() {
        return new GalaxyTab();
    }
}
