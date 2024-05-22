package homeWorks.finalProject;

public class Archer extends RangeUnit{
    public Archer(int healthPoint, int attack, int defense, int cost, int dodge) {
        super(healthPoint, attack, defense, cost, dodge);
    }


    @Override
    public int generatedDodge() {
        return 0;
    }

    @Override
    public void rangeAttack(Unit unit) {

    }
    cd 
}
