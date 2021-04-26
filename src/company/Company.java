package company;

import buildings.Building;

import java.util.ArrayList;
import java.util.List;

public class Company {
  private String name;
  private String level;
  private int visitor;
  private int money;
  private List<Building> buildings;

  public Company(String name, String level) {
    this.name = name;
    this.level = level;
    this.money = 150000;
    this.visitor = 10;
    buildings = new ArrayList<>();
  }

  public void build(Building building) throws Exception {
    boolean isContain = false;
    if(buildings.size() > 0){
      for (Building games: buildings) {
        if(games.getName().equals(building.getName())){
          isContain = true;
        }
      }
      if (!isContain) {
        this.setMoney(this.getMoney()-building.getCost());
        buildings.add(building);
      }
    } else {
      this.setMoney(this.getMoney()-building.getCost());
      buildings.add(building);
    }
  }

  public void development(Building building){
    if(building.getLevelOfDevelopment() < 10){
      building.setCost(building.getCost()*building.getLevelOfDevelopment());
      this.setMoney(this.getMoney()-building.getCost());
      building.setProfit(building.getProfit()+(building.getProfit()/building.getLevelOfDevelopment()));
      building.setLevelOfDevelopment(building.getLevelOfDevelopment()+1);
    } else {

    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public int getVisitor() {
    return visitor;
  }

  public void setVisitor(int visitor) {
    this.visitor = visitor;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public List<Building> getBuildings() {
    return buildings;
  }

  public void setBuildings(List<Building> buildings) {
    this.buildings = buildings;
  }

  @Override
  public String toString() {
    return "My company name is " + this.name + ". "+this.level + " level. We have "+this.visitor+"" +
            " visitors and "+ this.money+" fabatka . "+getBuildings();

  }
}
