package students;

import building.Building;

public interface Student {

  int getLevel();

  int upgradeCost();

  void upgrade(Student student) throws Exception;

  int defence(Building building);

}
