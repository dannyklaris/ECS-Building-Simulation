package students;

import bugs.Bug;
import building.Building;
import java.util.Arrays;
import java.util.Iterator;

public class AiStudent implements Student  {

  private int studentLevel;
  private int studentDelay = 7;


  public AiStudent (int level) {
    this.studentLevel = level;

  }

  @Override
  public int getLevel() {
    return studentLevel;
  }

  @Override
  public int upgradeCost() {
    return (int) (100 * (Math.pow(2, studentLevel)));
  }

  @Override
  public void upgrade(Student student) {
    studentLevel = student.getLevel() + 1;
  }

  @Override
  public int defence(Building building) {

    System.out.println();
    System.out.println("AiStudent is attacking the bugs!");
    int studentAttack = 7;
    int studentDamage = (int) Math.round(studentAttack * Math.pow(getLevel(), 1.2));
    if(!Arrays.asList(building.getAllBugs()).isEmpty()) {
      Iterator<Bug> bugIterator = Arrays.stream(building.getAllBugs()).iterator();
      Bug bug = bugIterator.next();

      if (studentDelay != 0) {
        System.out.println("studentDelay is " + studentDelay + ".");
        bug.damage(studentDamage);
        studentDelay--;

      }
      if(studentDelay == 0) {
        System.out.println("Special attack by AiStudent!");
        System.out.println("First 3 bugs is attacked!");
        if(Arrays.asList(building.getAllBugs()).size() > 2) {
          Arrays.asList(building.getAllBugs()).get(1).damage(studentDamage);
          Arrays.asList(building.getAllBugs()).get(2).damage(studentDamage);
          studentDelay = studentDelay + 6;
        }
        else {
          System.out.println("Special attack can't be applied!");
        }

      }
      if (bug.getCurrentHp() == 0) {
        building.removeBug(bug);
        return bug.getLevel() * 20;
      }
    }
    else {
      System.out.println("There is no bugs left!");
      System.out.println("Congratulations! Team Students successfully defended the building.");
      System.exit(0);
    }

    return 0;
  }

  @Override
  public String toString() {
    return "AiStudent || Level: " + studentLevel;
  }
}


