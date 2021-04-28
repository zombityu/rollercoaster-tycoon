package buildings;

import java.util.ArrayList;
import java.util.List;

public class CottonCandyVendor extends Building {
  public CottonCandyVendor(String level) {
    this.setName("CottonCandyVendor");
    this.setAccidentCost(1000);
    this.setVisitorDecrease(0);
    if(level.equals("easy")){
      this.setCost(50000);
      this.setProfit(10);
      this.setLevel("easy");
      this.setProbability(16);
    } else if(level.equals("normal")){
      this.setCost(100000);
      this.setProfit(5);
      this.setLevel("normal");
      this.setProbability(24);
    } else if(level.equals("hard")){
      this.setCost(150000);
      this.setProfit(2);
      this.setLevel("hard");
      this.setProbability(80);
    }
  }

  @Override
  public String toString() {
    return "CottonCandyVendor cost "+this.getCost()+", profit "+this.getProfit()+", level "+this.getLevelOfDevelopment();
  }
}
