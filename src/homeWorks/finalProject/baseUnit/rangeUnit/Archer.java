package homeWorks.finalProject.baseUnit.rangeUnit;

import homeWorks.finalProject.otherInterfaces.Clonable;
import homeWorks.finalProject.baseUnit.Unit;

import java.util.Random;

public class Archer extends RangeUnit implements Clonable {

    public Archer(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge, int range) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge, range);
    }

    public Archer(Archer archer) {
        super(archer);
    }

    @Override
    public int generatedDodge() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber <= 5) {
            return 1;
        }
        return 0;
    }

    private int generatedCriticalDamageForRange() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber <= 20) {
            return 3;
        }
        return 1;
    }

    @Override
    public Unit rangeAction(Unit unit) {
        int commonDamage = this.getAttack() * generatedCriticalDamageForRange() - unit.getDodge() * unit.generatedDodge();
        int currentHp = unit.getCurrentHealthPoint();

        unit.setCurrentHealthPoint(currentHp - commonDamage);
        return unit;
    }

    @Override
    public Unit clone() {
        return new Archer(this);
    }



}
