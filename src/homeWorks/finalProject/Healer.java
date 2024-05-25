package homeWorks.finalProject;

import java.util.Random;

public class Healer extends RangeUnit {
    private final int healingAmount;

    public Healer(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge, int range, int healingAmount) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge, range);
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    @Override
    public Unit rangeAction(Unit unit) {
        int currentHp = unit.getCurrentHealthPoint();

        unit.setCurrentHealthPoint(Math.min(currentHp + healingAmount, unit.getMaxHealth()));
        return unit;
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
}
