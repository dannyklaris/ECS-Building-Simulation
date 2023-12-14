package bugs;

// ArithmeticBug's special ability is in dealing the damage to the building when it is removed. It can be seen in Building class under bugsMove method.

public class ArithmeticBug extends Bug{

    private final int baseHp = 300;
    private final int baseSteps = 8;

    public ArithmeticBug(String name, int level, int initialSteps) {
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

        if (currentSteps > 0) {
            currentSteps--;
        }
        else {
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

