package buildings;

public class Building {
  private String name;
  private int cost;
  private int profit;
  private String level;
  private int levelOfDevelopment;
  private double probability;
  private int accidentCost;
  private int visitorDecrease;
  private String accident;

  public Building() {
    this.setLevelOfDevelopment(1);
  }

  public int getAccidentCost() {
    return accidentCost;
  }

  public void setAccidentCost(int accidentCost) {
    this.accidentCost = accidentCost;
  }

  public int getVisitorDecrease() {
    return visitorDecrease;
  }

  public void setVisitorDecrease(int visitorDecrease) {
    this.visitorDecrease = visitorDecrease;
  }

  public double getProbability() {
    return probability;
  }

  public void setProbability(double probability) {
    this.probability = probability;
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

  public String getAccident() {
    return accident;
  }

  public void setAccident(String accident) {
    this.accident = accident;
  }
}
