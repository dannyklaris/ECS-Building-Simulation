package bugs;

import students.Toolbox;

// InvocationTargetBug's special ability is have the chance to heal 100 HP and deal additional damage 25% to the building.
// This can be seen under move() method and Building bugsMove() method.

public class InvocationTargetBug extends Bug{

    private final int baseHp = 1000;
    private final int baseSteps = 12;

    public InvocationTargetBug(String name, int level, int initialSteps) {
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
        int random = toolbox.getRandomInteger(10);

        if (currentSteps > 0) {
            currentSteps--;

        }
        else {

            if (random >= 5) {
                System.out.println();
                System.out.println(getName() + " special ability! " + getName() + "'s HP is added by 100.");
                currentHp = currentHp + 100;
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

