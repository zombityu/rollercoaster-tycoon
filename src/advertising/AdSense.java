package advertising;

public class AdSense extends Advertising{
  public AdSense(String level) {
    this.setName("AdSense");
    this.setPeriod(16);
    if(level.equals("easy")){
      this.setCost(256000);
      this.setVisitorPerDay(12800);
    }else if(level.equals("normal")){
      this.setCost(512000);
      this.setVisitorPerDay(6400);
    }else if(level.equals("hard")){
      this.setCost(1024000);
      this.setVisitorPerDay(3200);
    }
  }
}
