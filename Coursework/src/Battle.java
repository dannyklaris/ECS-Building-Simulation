
import bugs.Bug;
import building.Building;
import java.util.Arrays;
import students.Team;

public class Battle {
  Team team;
  Building building;
  int a = 0;

  public Battle(Team team, Building building) {
    this.team = team;
    this.building = building;
  }

  public void manageTeam() throws Exception {

    if (team.getKnowledgePoints() > team.getNewStudentCost()) {
      team.recruitNewStudent();
    }
    if (team.getKnowledgePoints() > team.upgradeCost()) {
      team.upgrade(team.getStudents().get(a));
      a++;
    }

  }

  public void step() throws Exception {

    while (team.getKnowledgePoints() > team.getNewStudentCost() && team.getKnowledgePoints() > team.upgradeCost()) {
      System.out.println("Checking if knowledge points is sufficient!");
      System.out.println("It is sufficient!");
      manageTeam();

      if (team.getKnowledgePoints() < team.getNewStudentCost() && team.getKnowledgePoints() < team.upgradeCost()) {
        break;
      }
    }

    for (int i = 0; i < 7; i++) {

      building.bugsMove();

      if (Arrays.asList(building.getAllBugs()).isEmpty()) {
        break;
      }

      else if (building.getConstructionPoints() == 0) {
        System.out.println("Building has 0 construction points! You have lost!");
        System.console().flush();
        System.exit(0);
      }
    }
    for (int i = 0; i < 7; i++) {
      
      if (!Arrays.asList(building.getAllBugs()).isEmpty()) {
        team.studentsAct(building);
      }
      else if (building.getConstructionPoints() == 0) {
        System.out.println("Building has 0 construction points! You have lost!");
        break;
      }
      else {
        break;
      }
    }

    System.out.println("List of bugs in the building: ");
    for (Bug bug : building.getAllBugs()) {
      System.out.println(bug);
    }
    System.out.println();
    System.out.println("currentKnowledgePoints: " + team.getKnowledgePoints());
    System.out.println("Building's constructionPoints: " + building.getConstructionPoints());
    System.out.println("****************************************************************************");
    System.out.println("One step of simulation has finished!");
    System.out.println("Starting another step simulation in 5 seconds!");
    Thread.sleep(5000);

  }

}
