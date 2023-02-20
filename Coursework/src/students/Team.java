package students;

import building.Building;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Team implements Student {

  int knowledgePoints;
  int NewStudentCost = 100;
  ArrayList<Student> studentArrayList = new ArrayList<>();

  public Team (int  teamKnowledge) {
    this.knowledgePoints = teamKnowledge;
  }

  public int getKnowledgePoints() {
    System.out.println();
    return knowledgePoints;
  }

  public ArrayList<Student> getStudents() {
    System.out.println();
    System.out.println("Students protecting the building:");
    for (Student student : studentArrayList) {
      System.out.println(student);
    }
    return studentArrayList;
  }

  public int studentsAct(Building building) {
    System.out.println();
    System.out.println("Students are defencing the building!");

    for (Student student : studentArrayList) {
      if(!Arrays.asList(building.getAllBugs()).isEmpty()) {
        knowledgePoints = knowledgePoints + student.defence(building);
      }
      else {
        System.out.println("There is no bugs left in the building!");
        break;
      }

    }
    return knowledgePoints;
  }

  public int getNewStudentCost() {
    return NewStudentCost;
  }

  public void recruitNewStudent() throws Exception {

    Random random = new Random();
    int val = random.nextInt(4);

    if(knowledgePoints > NewStudentCost) {
      if (val == 0) {
        studentArrayList.add(new SeStudent(1));
        System.out.println("SeStudent has been recruited.");
        knowledgePoints = knowledgePoints - NewStudentCost;
        NewStudentCost = NewStudentCost + 10;
      }
      if (val == 1) {
        studentArrayList.add(new CsStudent(1));
        System.out.println("CsStudent has been recruited.");
        knowledgePoints = knowledgePoints - NewStudentCost;
        NewStudentCost = NewStudentCost + 10;
      }
      if (val == 2) {
        studentArrayList.add(new CyberStudent(1));
        System.out.println("CyberStudent has been recruited.");
        knowledgePoints = knowledgePoints - NewStudentCost;
        NewStudentCost = NewStudentCost + 10;
      }
      if (val == 3) {
        studentArrayList.add(new AiStudent(1));
        System.out.println("AiStudent has been recruited.");
        knowledgePoints = knowledgePoints - NewStudentCost;
        NewStudentCost = NewStudentCost + 10;
      }
    }

    else if (knowledgePoints < NewStudentCost) {
      throw new Exception("Insufficient knowledge points.");
    }
  }


  @Override
  public int getLevel() {
    return 0;
  }

  @Override
  public int upgradeCost()  {
    return (int) (100 * (Math.pow(2, getLevel())));
  }

  @Override
  public void upgrade(Student student) throws Exception {
    System.out.println(student + " is upgraded!");
    if (knowledgePoints > upgradeCost()) {
      student.upgrade(student);
    }
    else if (knowledgePoints < upgradeCost()) {
      throw new Exception("Insufficient knowledge points to upgrade student.");
    }
  }

  @Override
  public int defence(Building building) {
    return 0;
  }
}
