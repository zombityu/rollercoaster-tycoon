package buildings;

public class GhostTrain extends Building{
  public GhostTrain(String level) {
    this.setName("GhostTrain");
    if(level.equals("easy")){
      this.setCost(400000);
      this.setProfit(80);
      this.setLevel("easy");
    } else if(level.equals("normal")){
      this.setCost(600000);
      this.setProfit(40);
      this.setLevel("normal");
    } else if(level.equals("hard")){
      this.setCost(800000);
      this.setProfit(20);
      this.setLevel("hard");
    }
  }

  @Override
  public String toString() {
    return this.getName()+" cost "+this.getCost()+", profit "+this.getProfit()+", level "+this.getLevelOfDevelopment();
  }
}
