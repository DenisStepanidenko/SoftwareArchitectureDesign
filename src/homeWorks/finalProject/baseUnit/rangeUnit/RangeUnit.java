package homeWorks.finalProject.baseUnit.rangeUnit;

import homeWorks.finalProject.otherInterfaces.Range;
import homeWorks.finalProject.baseUnit.Unit;

public abstract class RangeUnit extends Unit implements Range {
    private final int range;

    public RangeUnit(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge, int range) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge);
        this.range = range;
    }

    public RangeUnit(Archer archer) {
        super(archer);
        this.range = archer.getRange();
    }

    public int getRange() {
        return range;
    }

    @Override
    public void meleeAttack(Unit unit) {
        // формула для атаки
        int commonDamage = this.getAttack() - unit.getDefense() - unit.generatedDodge() * unit.getDodge();
        if(commonDamage < 0){
            return;
        }
        int currentHp = unit.getCurrentHealthPoint();
        unit.setCurrentHealthPoint(currentHp - commonDamage);
    }


}
