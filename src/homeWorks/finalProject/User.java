package homeWorks.finalProject;

import homeWorks.finalProject.baseUnit.Unit;

import java.util.Stack;

public class User {
    private String name;
    private int totalSumOfMoney;
    private Stack<Unit> allUnits;

    public User(String name, int totalSumOfMoney, Stack<Unit> allUnits) {
        this.name = name;
        this.totalSumOfMoney = totalSumOfMoney;
        this.allUnits = allUnits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalSumOfMoney() {
        return totalSumOfMoney;
    }

    public Stack<Unit> getAllUnits() {
        return allUnits;
    }

    public void setTotalSumOfMoney(int totalSumOfMoney) {
        this.totalSumOfMoney = totalSumOfMoney;
    }

    public void setAllUnits(Stack<Unit> allUnits) {
        this.allUnits = allUnits;
    }
}
