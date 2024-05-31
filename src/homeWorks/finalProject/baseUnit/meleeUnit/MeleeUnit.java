package homeWorks.finalProject.baseUnit.meleeUnit;

import homeWorks.finalProject.baseUnit.Unit;

public abstract class MeleeUnit extends Unit {

    public MeleeUnit(int maxHealth, int currentHealthPoint, int attack, int defense, int cost, int dodge) {
        super(maxHealth, currentHealthPoint, attack, defense, cost, dodge);
    }

    public MeleeUnit(LightUnit target) {
        super(target);
    }

    /**
     * Метод, который генерирует шанс критического урона у ближников
     *
     * @return возвращает число, которое соответствует коэффициенту, на который будем умножаться атака
     */
    public abstract int generateCriticalDamageForMeleeAttack();




    /**
     * Метод, который совершает атаку у ближника
     *
     * @param unit персонаж, по которому ведётся атака
     */
    @Override
    public void meleeAttack(Unit unit) {
        // формула для атаки
        int commonDamage = this.getAttack() * generateCriticalDamageForMeleeAttack() - unit.getDefense() - unit.generatedDodge() * unit.getDodge();
        if(commonDamage < 0){
            return;
        }
        int currentHp = unit.getCurrentHealthPoint();
        unit.setCurrentHealthPoint(currentHp - commonDamage);
    }

}
