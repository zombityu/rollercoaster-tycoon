package buildings;

public class BoatingLake extends Building{
  public BoatingLake(String level) {
    this.setName("BoatingLake");
    this.setAccidentCost(50000);
    this.setVisitorDecrease(10);
    this.setAccident("The boat sinks!");
    if(level.equals("easy")){
      this.setCost(200000);
      this.setProfit(40);
      this.setLevel("easy");
      this.setProbability(4);
    } else if(level.equals("normal")){
      this.setCost(300000);
      this.setProfit(20);
      this.setProbability(6);
      this.setLevel("normal");
    } else if(level.equals("hard")){
      this.setCost(400000);
      this.setProfit(10);
      this.setLevel("hard");
      this.setProbability(9);
    }
  }

  @Override
  public String toString() {
    return this.getName()+" cost "+this.getCost()+", profit "+this.getProfit()+", level "+this.getLevelOfDevelopment();
  }
}
