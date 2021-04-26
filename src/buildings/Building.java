package buildings;

import java.util.Objects;

public class Building {
  private String name;
  private int cost;
  private int profit;
  private String level;
  private int levelOfDevelopment;

  public Building() {
    this.setLevelOfDevelopment(1);
  }

  public Building(String level) {
    this.level = level;
    this.setLevelOfDevelopment(1);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getProfit() {
    return profit;
  }

  public void setProfit(int profit) {
    this.profit = profit;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public int getLevelOfDevelopment() {
    return levelOfDevelopment;
  }

  public void setLevelOfDevelopment(int levelOfDevelopment) {
    if(this.levelOfDevelopment <= 10){
      this.levelOfDevelopment = levelOfDevelopment;
    } else {
      System.out.println("You have reached the maximum level of development.");
    }
  }
}
