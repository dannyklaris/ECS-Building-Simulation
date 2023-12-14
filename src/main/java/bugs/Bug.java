package bugs;

public class Bug implements Comparable<Bug> {

  // Basic properties for the Bug class
  public String name;
  private int baseHp;
  private int baseSteps;
  public int level;

  // 1st constructor for the bug
  public Bug (String name, int baseHp, int baseSteps, int level) {
    this.name = name;
    this.baseHp = baseHp;
    this.baseSteps = baseSteps;
    this.level = level;
    this.currentHp = baseHp;
    this.currentSteps = baseSteps;
  }
  // Accessor methods
  public int getBaseSteps() {
    return baseSteps;
  }
  public int getLevel() {
    return level;
  }
  public String getName() {
    return name;
  }

  // Additional properties for the bug class
  private int currentHp = (int)Math.round((double)this.baseHp * Math.pow(this.level, 1.50));
  private int currentSteps; // if it is 0, the bug move to the next location when it moves.
  private int currentFloor = -1; //initially at -1;

  // 2nd constructor with initialisation
  public Bug(String name, int baseHp, int baseSteps, int level, int initialSteps) {
    this.name = name;
    this.baseHp = baseHp;
    this.baseSteps = baseSteps;
    this.level = level;
    this.currentSteps = initialSteps;
  }

  // Accessor methods for 2nd constructor
  public int getCurrentHp() {
    return currentHp;
  }

  public int getCurrentSteps() {
    return currentSteps;
  }

  public int getCurrentFloor() {
    return currentFloor;
  }

  // Additional setter methods

  public void setCurrentFloor(int floor) {
    this.currentFloor = floor;
  }

  // Methods for bug class
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

  public Bug(String name, int level, int initialSteps) {
    this.name = name;
    this.level = level;
    this.currentSteps = initialSteps;
  }

  @Override
  public int compareTo(Bug bug) {

    if(this.getCurrentFloor() > bug.getCurrentFloor()) {
      return -1;
    }
    if(this.getCurrentFloor() == bug.getCurrentFloor() && this.getCurrentSteps() < bug.getCurrentSteps()) {
      return -1;
    }
    else {
      return 0;
    }
  }

  public String toString() {
    return "Bug: " + name + " ||" +" Level: " + level + " || " + "HP: " + getCurrentHp();
  }
}


