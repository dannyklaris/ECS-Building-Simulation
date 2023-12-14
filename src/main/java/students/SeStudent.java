package students;

import bugs.Bug;
import building.Building;
import java.util.Arrays;
import java.util.Iterator;

public class SeStudent implements Student{

  private int studentLevel;
  private int studentDelay = 6;

  public SeStudent(int level) {

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
    System.out.println("SeStudent is attacking the bugs!");
    int studentAttack = 5;
    int studentDamage = (int) Math.round(studentAttack * Math.pow(getLevel(), 1.2));

    if (!Arrays.asList(building.getAllBugs()).isEmpty()) {
      Iterator<Bug> bugIterator = Arrays.stream(building.getAllBugs()).iterator();

      while (bugIterator.hasNext()) {
        Bug bug = bugIterator.next();
        if (studentDelay >= 2) {
          System.out.println("studentDelay: " + studentDelay);
          bug.damage(studentDamage);
          studentDelay--;
          break;
        }
        System.out.println();
        System.out.println("Special attack by SeStudent!");
        System.out.println("The first 5 bugs will be slowed down!");
        bug.slowDown(2);

        studentDelay--;
        if(studentDelay == -4) {
          studentDelay += 10;
        }
        if (bug.getCurrentHp() == 0) {
          building.removeBug(bug);
          return bug.getLevel() * 20;
        }
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
    return "SeStudent || Level: " + studentLevel;
  }
}
