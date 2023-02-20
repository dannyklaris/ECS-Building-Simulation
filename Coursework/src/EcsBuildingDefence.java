import bugs.*;
import building.Building;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import students.Team;


public class EcsBuildingDefence {

  private static final ArrayList<Bug> bugArrayList = new ArrayList<>();
  private static int topFloor;
  private static String[] argss;
  private static int constructionPoints;
  private static int knowledgePoints;

  public void parseInteger() {
    topFloor = Integer.parseInt(argss[0]);
    constructionPoints = Integer.parseInt(argss[1]);
    knowledgePoints = Integer.parseInt(argss[3]);
  }

  public static void main(String[] args) {

    EcsBuildingDefence ecs = new EcsBuildingDefence();

    argss = args;

    ecs.parseInteger();

    Building building = new Building(topFloor, constructionPoints);
    Team team = new Team(knowledgePoints);
    Battle battle = new Battle(team, building);
    // Reading line by line in a notepad. This is partly referenced and guided by the sample of Michael Richards. (mr7g20.jar)
    try (BufferedReader reader = new BufferedReader(new FileReader(args[2]))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] strings = line.split(";");

        for (String line1 : strings) {
          String[] strings2 = line1.split("\\(");
          String bugName = strings2[0];
          String[] strings3 = strings2[1].split(",");
          String bugType = strings3[0];
          String[] strings4 = strings3[2].split("\\)");

          int bugSteps = Integer.parseInt(strings4[0].replace(")", ""));
          int bugLevel = Integer.parseInt(strings3[1].replace("(", ""));

          if (bugType.equals("NPB")) {
            Bug a = new NullPointerBug(bugName, bugLevel, bugSteps);
            bugArrayList.add(a);
            building.addBug(a);
          }
          if (bugType.equals("CMB")) {
            Bug b = new ConcurrentModificationBug(bugName, bugLevel, bugSteps);
            bugArrayList.add(b);
            building.addBug(b);
          }
          if (bugType.equals("NTB")) {
            Bug c = new NoneTerminationBug(bugName, bugLevel, bugSteps);
            bugArrayList.add(c);
            building.addBug(c);
          }
          if (bugType.equals("AB")) {
            Bug d = new ArithmeticBug(bugName, bugLevel, bugSteps);
            bugArrayList.add(d);
            building.addBug(d);
          }
          if (bugType.equals("IB")) {
            Bug e = new InterruptedBug(bugName, bugLevel, bugSteps);
            bugArrayList.add(e);
            building.addBug(e);
          }
          if (bugType.equals("ITB")) {
            Bug f = new InvocationTargetBug(bugName, bugLevel, bugSteps);
            bugArrayList.add(f);
            building.addBug(f);
          }
        }
        if (bugArrayList.size() >= 10) {
          System.out.println("The first wave of bugs incoming!");
          int a = 8 * topFloor;
          for (int b = 0; b < a; b++) {
            if (building.getConstructionPoints() == 0){
              System.out.println("Game over!");
              System.exit(0);
            }
            battle.step();
            if (building.getAllBugs().length == 0) {
              break;
            }
          }
          if (Arrays.asList(building.getAllBugs()).isEmpty()) {
            int b = 8 * topFloor;
            for (int c = 0; c < b; c++) {
              if (building.getConstructionPoints() == 0){
                System.out.println("Game over!");
                System.exit(0);
              }
              System.out.println("Next wave of bugs incoming!");
              battle.step();
              if (building.getAllBugs().length == 0) {
                System.out.println(
                    "Congratulations! Team Student have successfully defended the building!");
                System.out.println("Next wave of bugs incoming in 5 seconds!");
                Thread.sleep(5000);
                break;
              }
            }
          }
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Total bugs in building: " + building.getAllBugs().length);
    System.out.println("Total students recruited: " + team.getStudents().size());
  }

}