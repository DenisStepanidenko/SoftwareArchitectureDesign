package homeWorks.finalProject;

public abstract class Unit {
    private int healthPoint;
    private final int attack;
    private final int defense;
    private final int cost;
    private final int dodge;

    public Unit(int healthPoint, int attack, int defense, int cost, int dodge) {
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.dodge = dodge;

    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getCost() {
        return cost;
    }

    public int getDodge() {
        return dodge;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public abstract int generatedDodge();

    public abstract void attack(Unit unit);

}
