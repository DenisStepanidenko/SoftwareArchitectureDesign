package homeWorks.finalProject;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        //Unit unit = new LightUnit(1, 2, 3, 4, 5);
//        //Mage mage = new Mage(1,2,3,4,5,6,7);
//
//        Archer lightUnit = new Archer(1,2,3,4,5,6,7);
//        Archer newUnit = (Archer) lightUnit.clone();
//
//        System.out.println(lightUnit == newUnit);
//        System.out.println(lightUnit);
//        System.out.println(newUnit);
//        //mage.rangeAction(lightUnit);

//        UnitFactory unitFactory = new UnitFactory();
//        Unit healer = unitFactory.getHealer();
//        Healer healer1 = (Healer) healer;
//        System.out.println(healer1.getHealingAmount());

        Stack<Unit> test = new Stack<>();
        MeleeUnit meleeUnit = new LightUnit(1,2,3,4,5,6);
        test.add(meleeUnit);
        System.out.println(test);


    }
}
