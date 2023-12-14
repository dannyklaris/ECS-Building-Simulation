package building;


import bugs.*;
import students.Toolbox;

import java.util.*;

public class Building {
  // Properties for the Building class
  private int constructionPoints;
  private final int topFloor;
  private final ArrayList<Bug> bugs = new ArrayList<>();

  public Building (int topFloor, int constructionPoints) {
    this.topFloor = topFloor;
    this.constructionPoints = constructionPoints;
  }

  // Getter and Setter methods
  public int getTopFloor() {
    return topFloor;
  }

  public int getConstructionPoints() {
    return constructionPoints;
  }

  // Method 1: getAllBugs()
  public Bug[] getAllBugs() {
    ArrayList<Bug> bugArrayList = new ArrayList<>();

    for (Bug bug1 : bugs) {
      if (bug1.getCurrentFloor() != -1) {
        bugArrayList.add(bug1);
        Collections.sort(bugArrayList);
      }
    }
    Collections.sort(bugArrayList);
    return bugArrayList.toArray(new Bug[bugArrayList.size()]);
  }
// Method 2: addBug(Bug bug)
  public int addBug(Bug bug) {

    System.out.println(bug + " is added.");
    System.out.println();

    if (!bugs.contains(bug)) {
      bugs.add(bug);
    }
    else if (bugs.contains(bug)) {
      return -1;
    }
    return bugs.size();
  }
// Method 3: removeBug(Bug bug)
  public void removeBug(Bug bug) {
    Iterator<Bug> i = bugs.iterator();
    while (i.hasNext()) {
      Bug bug1 = i.next();
      if (bug1 == bug) {
        i.remove();
        System.out.println(bug + " is removed.");
      }
    }
  }
  // Method 4: bugsMove()
  public void bugsMove() {

    System.out.println();
    System.out.println("All bugs will move one step!");

    for (Bug b : bugs) {
      b.move();
    }

    Iterator<Bug> i = bugs.iterator();
    while (i.hasNext()) {
      Bug bug = i.next();
      System.out.println();
      System.out.println(bug.name + " currentFloor: " + bug.getCurrentFloor());
      System.out.println(bug.name + " currentSteps: " + bug.getCurrentSteps());



      if (bug.getCurrentFloor() == topFloor || bug.getCurrentFloor() >= topFloor) {

        if (bug instanceof NullPointerBug) {
          constructionPoints = constructionPoints - 1;
          i.remove();
          System.out.println(bug + " has reached the top floor! Building construction points will be decreased!");
        }
        if (bug.getCurrentSteps() == 3) {
          if (bug instanceof ConcurrentModificationBug) {
            constructionPoints = constructionPoints - 2;
            i.remove();
            System.out.println(bug + " has reached the top floor! Building construction points will be decreased!");
          }
        }
        if (bug.getCurrentSteps() == 5) {
          if (bug instanceof NoneTerminationBug) {
            constructionPoints = constructionPoints - 4;
            i.remove();
            System.out.println(bug + " has reached the top floor! Building construction points will be decreased!");
          }
        }

        if (bug.getCurrentSteps() == 7) {
          if (bug instanceof ArithmeticBug) {
            Toolbox toolbox = new Toolbox();
            int random = toolbox.getRandomInteger(10);
            if(random >= 5) {
              System.out.println();
              System.out.println(bug + " special ability! Double damage is applied to building!");
              constructionPoints = constructionPoints - (6 * 2);
            }
            constructionPoints = constructionPoints - 6;
            i.remove();
            System.out.println(bug + " has reached the top floor! Building construction points will be decreased!");
          }
        }

        if (bug.getCurrentSteps() == 9) {
          if (bug instanceof InterruptedBug) {
            constructionPoints = constructionPoints - 8;
            i.remove();
            System.out.println(bug + " has reached the top floor! Building construction points will be decreased!");
          }
        }

        if (bug.getCurrentSteps() == 11) {
          if (bug instanceof InvocationTargetBug) {
            Toolbox toolbox = new Toolbox();
            int randomNumber = toolbox.getRandomInteger(10);
            if (randomNumber >= 5) {
              int b = (constructionPoints/4);
              System.out.println();
              System.out.println(bug + " special ability! Additional damage is applied to Building!");
              constructionPoints = constructionPoints - b;
            }
            constructionPoints = constructionPoints - 10;
            i.remove();
            System.out.println(bug + " has reached the top floor! Building construction points will be decreased!");
          }
        }
      }



      if (constructionPoints <= 0) {
        constructionPoints = 0;
        break;
      }

    }
  }
}
