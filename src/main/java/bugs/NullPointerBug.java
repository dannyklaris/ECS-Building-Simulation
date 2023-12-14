package bugs;

import students.Toolbox;


// NullPointerBug's special ability is it can have 50% chance to skip 1 floor.
public class NullPointerBug extends Bug {

  private final int baseHp = 10;
  private final int baseSteps = 2;

  public NullPointerBug(String name, int level, int initialSteps) {
    super(name, level, initialSteps);
    this.currentSteps = initialSteps;
  }

  private int currentHp  = (int)Math.round((double)this.baseHp * Math.pow(this.level, 1.50));
  private int currentSteps;// if it is 0, the bug move to the next location when it moves.
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
        System.out.println(getName() + " special ability! " + getName() + " skips 1 floor!");
        currentFloor += 1;
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
