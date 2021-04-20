package advertising;

public class NewspaperAd extends Advertising{
  public NewspaperAd(String level) {
    this.setName("Newspaper Ad");
    this.setPeriod(2);
    if(level.equals("easy")){
      this.setCost(4000);
      this.setVisitorPerDay(200);
    }else if(level.equals("normal")){
      this.setCost(8000);
      this.setVisitorPerDay(100);
    }else if(level.equals("hard")){
      this.setCost(16000);
      this.setVisitorPerDay(50);
    }
  }
}
