package buildings;

public class Carousel extends Building{
  public Carousel(String level) {
    this.setName("Carousel");
    this.setAccidentCost(25000);
    this.setVisitorDecrease(5);
    if(level.equals("easy")){
      this.setCost(100000);
      this.setProfit(20);
      this.setLevel("easy");
      this.setProbability(8);
    } else if(level.equals("normal")){
      this.setCost(150000);
      this.setProfit(10);
      this.setLevel("normal");
      this.setProbability(12);
    } else if(level.equals("hard")){
      this.setCost(200000);
      this.setProfit(5);
      this.setLevel("hard");
      this.setProbability(18);
    }
  }

  @Override
  public String toString() {
    return this.getName()+" cost "+this.getCost()+", profit "+this.getProfit()+", level "+this.getLevelOfDevelopment();
  }
}
