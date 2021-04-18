public class Company {
  private String name;
  private String level;
  private int visitor;
  private int money;

  public Company() {
  }

  public Company(String name, String level, int visitor, int money) {
    this.name = name;
    this.level = level;
    this.visitor = visitor;
    this.money = money;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public int getVisitor() {
    return visitor;
  }

  public void setVisitor(int visitor) {
    this.visitor = visitor;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }
}
