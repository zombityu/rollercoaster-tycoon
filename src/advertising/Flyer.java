package advertising;

public class Flyer extends Advertising{
  public Flyer(String level) {
    this.setName("Flyer");
    this.setPeriod(1);
    if(level.equals("easy")){
      this.setCost(1000);
      this.setVisitorPerDay(50);
    }else if(level.equals("normal")){
      this.setCost(2000);
      this.setVisitorPerDay(25);
    }else if(level.equals("hard")){
      this.setCost(4000);
      this.setVisitorPerDay(13);
    }
  }
}
