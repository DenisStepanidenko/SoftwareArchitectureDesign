package homeWorks.finalProject;

import homeWorks.finalProject.baseUnit.Unit;
import homeWorks.finalProject.baseUnit.meleeUnit.HeavyUnit;
import homeWorks.finalProject.baseUnit.meleeUnit.LightUnit;
import homeWorks.finalProject.baseUnit.rangeUnit.Archer;
import homeWorks.finalProject.buffUnit.BuffAttackHeavy;
import homeWorks.finalProject.buffUnit.BuffDefenseHeavy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.start();
    }
}
