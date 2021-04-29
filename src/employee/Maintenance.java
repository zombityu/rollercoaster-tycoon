package employee;

import java.util.Random;

public class Maintenance extends Employee{

  private int numbersOfEmployee;
  private int fee;
  Random rand;
  int probability;

  public Maintenance(int numbersOfEmployee) {
    rand = new Random();
    probability = rand.nextInt(3)+1;
    setNumbersOfEmployee(numbersOfEmployee);
    this.setReduceProbability(probability*getNumbersOfEmployee());
    this.fee = probability*getNumbersOfEmployee();
  }

  public int getNumbersOfEmployee() {
    return numbersOfEmployee;
  }

  public void setNumbersOfEmployee(int numbersOfEmployee) {
    if(numbersOfEmployee <= 5){
      this.numbersOfEmployee = numbersOfEmployee;
    } else {
      System.out.println("You can only employ 5 maintainers");
    }
  }

  public int getFee() {
    return fee;
  }

  public void setFee(int fee) {
    this.fee = fee;
  }
}
