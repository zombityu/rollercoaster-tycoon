package advertising;

public class Advertising {
  private String name;
  private int cost;
  private int visitorPerDay;
  private int tempVisitorPerDay;
  private int period;
  private boolean isActive;
  private int periodCounter;

  public Advertising() {
    this.tempVisitorPerDay = getVisitorPerDay();
  }

  public void regenerate(){
    if(tempVisitorPerDay > this.getVisitorPerDay()*1.1){
      this.setVisitorPerDay((int)(this.getVisitorPerDay()*1.1));
    } else {
      this.setVisitorPerDay(this.getTempVisitorPerDay());
    }
  }

  public int getTempVisitorPerDay() {
    return tempVisitorPerDay;
  }

  public void setTempVisitorPerDay(int tempVisitorPerDay) {
    this.tempVisitorPerDay = tempVisitorPerDay;
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

  public boolean isActive() {
    return isActive;
  }

  public int getPeriodCounter() {
    return periodCounter;
  }

  public void setPeriodCounter(int periodCounter) {
    this.periodCounter = periodCounter;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  @Override
  public String toString() {
    return this.name + " cost: " + this.cost + ", visitor/day: " + this.visitorPerDay + ", period: " + this.period + " day(s)";
  }
}
