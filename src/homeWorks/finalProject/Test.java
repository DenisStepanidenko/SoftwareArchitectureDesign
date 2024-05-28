package homeWorks.finalProject;

import homeWorks.finalProject.baseUnit.Unit;
import homeWorks.finalProject.baseUnit.meleeUnit.LightUnit;
import homeWorks.finalProject.baseUnit.rangeUnit.Archer;
import homeWorks.finalProject.buffUnit.BuffDefenseHeavy;

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
        //Unit heavyDecorator = new AttackHeavyDecorator(1, 2, 3, 4, 5, 6, new HeavyUnit(1, 2, 3, 4, 5, 6));

        // heavyDecorator.meleeAttack(new LightUnit(1, 2, 3, 4, 5, 6));
//
//        BuffDefenseHeavy buffAttackHeavy = new BuffDefenseHeavy(1, 2, 3, 4, 5, 6);
//
//        LightUnit lightUnit = new LightUnit(1, 2, 3, 4, 5, 6);
//
//        lightUnit.meleeAttack(buffAttackHeavy);

        //Game game = new Game();
        //game.start();

        Unit unit = new Archer(1,2,3,4,5,6,7);

        System.out.println(unit.getClass().getSimpleName());

    }
}
