package company;

import buildings.Building;
import buildings.Carousel;
import buildings.CottonCandyVendor;

import java.util.HashSet;
import java.util.Set;

public class Company {
  private String name;
  private String level;
  private int visitor;
  private int money;
  private Set<Building> buildings;

  public Company(String name, String level) {
    this.name = name;
    this.level = level;
    buildings = new HashSet<>();
  }

  public Company(String name, String level, int visitor, int money) {
    this.name = name;
    this.level = level;
    this.visitor = visitor;
    this.money = money;
    buildings = new HashSet<>();
  }

  public void build(Building building){
    if(building instanceof CottonCandyVendor){
      CottonCandyVendor cottonCandyVendor = new CottonCandyVendor(this.level);
      buildings.add(cottonCandyVendor);
    } else if(building instanceof Carousel){
      Carousel carousel = new Carousel(this.level);
      buildings.add(carousel);
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

  public Set<Building> getBuildings() {
    return buildings;
  }

  public void setBuildings(Set<Building> buildings) {
    this.buildings = buildings;
  }
}
