package bugs;

import students.Toolbox;

import java.util.Random;

// InterruptedBug's special ability is have the chance to gain complete HP again. This can be seen under move() method.

public class InterruptedBug extends Bug {

    private final int baseHp = 400;
    private final int baseSteps = 10;

    public InterruptedBug(String name, int level, int initialSteps) {
        super(name, level, initialSteps);
        this.currentSteps = initialSteps;
    }

    private int currentHp  = (int)Math.round((double)this.baseHp * Math.pow(this.level, 1.50));
    private int currentSteps; // if it is 0, the bug move to the next location when it moves.
    private int currentFloor = -1;

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentSteps() {
        return currentSteps;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getBaseSteps() {
        return baseSteps;
    }

    // 1st method: move()
    public void move() {

        Toolbox toolbox = new Toolbox();
        int randomNumber = toolbox.getRandomInteger(10);

        if (currentSteps > 0) {
            currentSteps--;
        }
        else {
            if (randomNumber >= 5) {
                System.out.println();
                System.out.println(getName() + " special ability!" + getName() + "'s HP is restored to maximum!");
                currentHp = baseHp;
            }
            currentFloor += 1;
            currentSteps = baseSteps - 1;
        }
    }
    // 2nd method: damage()
    public void damage(int amount) {
        if (amount < currentHp) {
            currentHp = currentHp - amount;
        }
        else {
            currentHp = 0;
        }
    }
    // 3rd method: slowDown()
    public void slowDown(int steps) {
        currentSteps += steps;
    }
}

