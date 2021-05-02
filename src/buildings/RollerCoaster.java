package buildings;

public class RollerCoaster extends Building{
  public RollerCoaster(String level) {
    this.setName("RollerCoaster");
    this.setAccidentCost(100000);
    this.setVisitorDecrease(20);
    this.setAccident("The roller coaster derails.");
    if(level.equals("easy")){
      this.setCost(800000);
      this.setProfit(160);
      this.setLevel("easy");
      this.setProbability(2);
    } else if(level.equals("normal")){
      this.setCost(1200000);
      this.setProfit(80);
      this.setLevel("normal");
      this.setProbability(3);
    } else if(level.equals("hard")){
      this.setCost(1600000);
      this.setProfit(40);
      this.setLevel("hard");
      this.setProbability(4.5);
    }
  }

  @Override
  public String toString() {
    return this.getName()+" cost "+this.getCost()+", profit "+this.getProfit()+", level "+this.getLevelOfDevelopment();
  }
}
