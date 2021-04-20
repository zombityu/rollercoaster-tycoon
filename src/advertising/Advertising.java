package advertising;

public class Advertising {
  private String name;
  private int cost;
  private int visitorPerDay;
  private int period;
  private String level;

  public Advertising() {
  }

  public Advertising(String level) {
    this.level = level;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getVisitorPerDay() {
    return visitorPerDay;
  }

  public void setVisitorPerDay(int visitorPerDay) {
    this.visitorPerDay = visitorPerDay;
  }

  public int getPeriod() {
    return period;
  }

  public void setPeriod(int period) {
    this.period = period;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
