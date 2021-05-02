package employee;

public class Accountant extends Employee{
  private final int numbersOfEmployee = 1;
  private final int fee = 2;

  public Accountant() {
    this.setName("Accountant");
  }

  public int getNumbersOfEmployee() {
    return numbersOfEmployee;
  }

  public int getFee() {
    return fee;
  }
}
