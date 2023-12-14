package bugs;

// ConcurrentModificationBug's special ability is having 50% chance to move faster than usual. This means, the currentSteps is shortcut to 1.

import students.Toolbox;

public class ConcurrentModificationBug extends Bug{

  private final int baseHp = 20;
  private final int baseSteps = 4;

  public ConcurrentModificationBug(String name, int level, int initialSteps) {
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
      if(random >= 5) {
        System.out.println();
        System.out.println(getName() + " special ability! " + getName() + " moves faster than usual!");
        currentSteps = 1;
      }
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
