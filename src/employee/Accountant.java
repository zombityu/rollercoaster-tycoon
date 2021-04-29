package employee;

public class Accountant extends Employee{
  private final int numbersOfEmployee = 1;
  private final int fee = 2;

  public Accountant() {
  }

  public int getNumbersOfEmployee() {
    return numbersOfEmployee;
  }

  public int getFee() {
    return fee;
  }
}
