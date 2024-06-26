package homeWorks.finalProject.baseUnit;

public abstract class Unit {
    private int maxHealth;
    private int currentHealthPoint;
    private int attack;
    private int defense;
    private int cost;
    private int dodge;


    @Override
    public String toString() {
        return "Unit{" +
                "maxHealth=" + maxHealth +
                ", currentHealthPoint=" + currentHealthPoint +
                ", attack=" + attack +
                ", defense=" + defense +
                ", cost=" + cost +
                ", dodge=" + dodge +
                '}';
    }

    public Unit(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge) {
        this.maxHealth = maxHealth;
        this.currentHealthPoint = currentHealthPoint;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.dodge = dodge;
    }

    public Unit(Unit target) {
        this.currentHealthPoint = target.getCurrentHealthPoint();
        this.maxHealth = target.getMaxHealth();
        this.attack = target.getAttack();
        this.defense = target.getDefense();
        this.cost = target.getCost();
        this.dodge = target.getDodge();
    }


    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealthPoint() {
        return currentHealthPoint;
    }

    public void setCurrentHealthPoint(int currentHealthPoint) {
        this.currentHealthPoint = currentHealthPoint;
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


    public abstract int generatedDodge();

    public abstract void meleeAttack(Unit unit);

}
