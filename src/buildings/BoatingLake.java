package buildings;

public class BoatingLake extends Building{
  public BoatingLake(String level) {
    this.setName("Boating Lake");
    if(level.equals("easy")){
      this.setCost(200000);
      this.setProfit(40);
      this.setLevel("easy");
    } else if(level.equals("normal")){
      this.setCost(300000);
      this.setProfit(20);
      this.setLevel("normal");
    } else if(level.equals("hard")){
      this.setCost(400000);
      this.setProfit(10);
      this.setLevel("hard");
    }
  }
}
