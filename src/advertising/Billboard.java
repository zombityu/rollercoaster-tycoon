package advertising;

public class Billboard extends Advertising{
  public Billboard(String level) {
    this.setName("Billboard");
    this.setPeriod(4);
    this.setPeriodCounter(this.getPeriod());
    if(level.equals("easy")){
      this.setCost(16000);
      this.setVisitorPerDay(800);
    }else if(level.equals("normal")){
      this.setCost(32000);
      this.setVisitorPerDay(400);
    }else if(level.equals("hard")){
      this.setCost(64000);
      this.setVisitorPerDay(200);
    }
  }
}
