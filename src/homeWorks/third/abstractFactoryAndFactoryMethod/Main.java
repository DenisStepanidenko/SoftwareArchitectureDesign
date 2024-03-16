package homeWorks.third.abstractFactoryAndFactoryMethod;

import homeWorks.third.abstractFactoryAndFactoryMethod.apple.AppleProductFactory;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.ElectronicProductFactory;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Laptop;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Pad;
import homeWorks.third.abstractFactoryAndFactoryMethod.interfaces.Smartphone;
import homeWorks.third.abstractFactoryAndFactoryMethod.samsung.SamsungProductFactory;

import java.util.Objects;
import java.util.Scanner;

// ==
// +=
// ++
// +
// =

public class Main {

    public static void main(String[] args) {

        ElectronicProductFactory factory;

        Scanner sc = new Scanner(System.in);

        System.out.println("Какой бренд вас интересует?" +
                "\nВведите 'apple' или 'a', чтобы выбрать бренд Apple, 'samsung' или 's', чтобы выбрать бренд Samsung.");

        while (true) {
            String choice = sc.nextLine().toLowerCase();

            if (Objects.equals(choice, "apple") || Objects.equals(choice, "a")) {
                factory = new AppleProductFactory();
                break;
            } else if (Objects.equals(choice, "samsung") || Objects.equals(choice, "s")) {
                factory = new SamsungProductFactory();
                break;
            } else {
                System.out.println("Введены некорректные данные. Попробуйте еще раз.");
            }
        }


        Smartphone phone = factory.createSmartphone();
        Laptop laptop = factory.createLaptop();
        Pad pad = factory.createPad();

        phone.showInfo();
        laptop.showInfo();
        pad.showInfo();
    }

}
