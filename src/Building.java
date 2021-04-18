
public abstract class Building {
  private String name;
  private int cost;
  private int profit;
  private int level;
  private int levelOfDevelopment;

  public Building() {
  }

  public Building(String name, int cost, int profit, int level, int levelOfDevelopment) {
    this.name = name;
    this.cost = cost;
    this.profit = profit;
    this.level = level;
    this.levelOfDevelopment = levelOfDevelopment;
  }

  public abstract void build(Company company);

  public void development(Building building){

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

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
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
