package buildings;

public class CottonCandyVendor extends Building {
  public CottonCandyVendor(String level) {
    this.setName("Cotton Candy Vendor");
    if(level.equals("easy")){
      this.setCost(50000);
      this.setProfit(10);
      this.setLevel("easy");
    } else if(level.equals("normal")){
      this.setCost(100000);
      this.setProfit(5);
      this.setLevel("normal");
    } else if(level.equals("hard")){
      this.setCost(150000);
      this.setProfit(2);
      this.setLevel("hard");
    }
  }
}
