package students;

import bugs.Bug;
import building.Building;
import java.util.Arrays;
import java.util.Iterator;

public class CsStudent implements Student{

  private int studentLevel;
  private int studentDelay = 6;

  public CsStudent(int level) {
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
    System.out.println("CsStudent is attacking the bugs!");
    int studentAttack = 6;
    int studentDamage = (int) Math.round(studentAttack * Math.pow(getLevel(), 1.2));
    if (!Arrays.asList(building.getAllBugs()).isEmpty()) {
      Iterator<Bug> bugIterator = Arrays.stream(building.getAllBugs()).iterator();
      Bug bug = bugIterator.next();

      if (studentDelay != 0) {
        System.out.println("studentDelay is " + studentDelay + ".");
        bug.damage(studentDamage);
        studentDelay--;

      }
      if(studentDelay == 0) {
        System.out.println();
        System.out.println("Special attack by CsStudent!");
        System.out.println("All bugs will be damaged four times the normal damage!");
        bug.damage(studentDamage * 4);
        studentDelay = studentDelay + 6;
      }

      if (bug.getCurrentHp() == 0) {
        building.removeBug(bug);
        return bug.getLevel() * 20;
      }
    }
    else {
      System.out.println("There is no bugs left!");
      System.out.println("Congratulations! Team Students successfully defended the building.");
    }
    return 0;
  }

  @Override
  public String toString() {
    return "CsStudent || Level: " + studentLevel;
  }
}
