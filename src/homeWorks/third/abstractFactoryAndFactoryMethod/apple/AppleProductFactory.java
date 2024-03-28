package homeWorks.third.abstractFactoryAndFactoryMethod.apple;

import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.ElectronicProductFactory;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Laptop;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Pad;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Smartphone;

public class AppleProductFactory implements ElectronicProductFactory {

    @Override
    public Smartphone createSmartphone() {
        return new IPhone();
    }

    @Override
    public Laptop createLaptop() {
        return new MacBook();
    }

    @Override
    public Pad createPad() {
        return new IPad();
    }
}
