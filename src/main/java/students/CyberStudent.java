package students;

import bugs.Bug;
import building.Building;
import java.util.Arrays;
import java.util.Iterator;

public class CyberStudent implements Student{

  private int studentLevel;
  private int studentDelay = 8;

  public CyberStudent (int level) {
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
    System.out.println("CyberStudent is attacking the bugs!" );
    int studentAttack = 7;
    int studentDamage = (int) Math.round(studentAttack * Math.pow(getLevel(), 1.2));
    Toolbox toolbox = new Toolbox();

    if(!Arrays.asList(building.getAllBugs()).isEmpty()) {
      Iterator<Bug> bugIterator = Arrays.stream(building.getAllBugs()).iterator();
      Bug bug = bugIterator.next();

      if (studentDelay != 0) {
        System.out.println("studentDelay: " + studentDelay + ".");
        bug.damage(studentDamage);
        studentDelay--;
      }

      if(studentDelay == 0) {
        System.out.println();
        System.out.println("Special attack by CyberStudent!");
        System.out.println("Bugs have a chance to be removed instantly!");
        int a = toolbox.getRandomInteger(50);
        if (a >= studentLevel + 20) {
          System.out.println("Bugs is removed instantly!");
          building.removeBug(bug);
          studentDelay = studentDelay + 8;
          return bug.getLevel() * 20;
        }
        if (a <= studentLevel + 20) {
          System.out.println(bug + " received double the damage!");
          bug.damage (studentDamage * 2);
          studentDelay = studentDelay + 8;
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
    return "CyberStudent || Level: " + studentLevel;
  }
}
