package buildings;

public class RollerCoaster extends Building{
  public RollerCoaster(String level) {
    if(level.equals("easy")){
      this.setCost(800000);
      this.setProfit(160);
      this.setLevel("easy");
    } else if(level.equals("normal")){
      this.setCost(1200000);
      this.setProfit(80);
      this.setLevel("normal");
    } else if(level.equals("hard")){
      this.setCost(1600000);
      this.setProfit(40);
      this.setLevel("hard");
    }
  }

  @Override
  public String toString() {
    return this.getName()+" cost "+this.getCost()+", profit "+this.getProfit()+", level "+this.getLevelOfDevelopment();
  }
}
