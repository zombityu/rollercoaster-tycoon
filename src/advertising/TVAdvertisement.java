package advertising;

public class TVAdvertisement extends Advertising{
  public TVAdvertisement(String level) {
    this.setName("TVAdvertisement");
    this.setPeriod(8);
    if(level.equals("easy")){
      this.setCost(64000);
      this.setVisitorPerDay(12800);
    }else if(level.equals("normal")){
      this.setCost(128000);
      this.setVisitorPerDay(6400);
    }else if(level.equals("hard")){
      this.setCost(256000);
      this.setVisitorPerDay(3200);
    }
  }
}
