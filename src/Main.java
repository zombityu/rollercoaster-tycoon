import buildings.Building;
import buildings.Carousel;
import buildings.CottonCandyVendor;
import company.Company;
import employee.Accountant;
import employee.Employee;
import employee.Maintenance;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Hello my dear! Welcome in our Roller Coaster Simulation!!");
    System.out.println("Please enter your company name:");
    String companyName = sc.nextLine();
    System.out.println("And please my lord choose a difficulty level:(easy, normal, hard)");
    String difficultyLevel = sc.nextLine();
    Company myComp = new Company(companyName,difficultyLevel);
    Building candy = new CottonCandyVendor(myComp.getLevel());
    Employee maintance = new Maintenance(3);
    Employee accountant = new Accountant();

    while(myComp.getMoney() > 0){
      try {
        myComp.employ(maintance);
        myComp.employ(accountant);
        myComp.build(candy);
      } catch (Exception e) {
        e.printStackTrace();
      }

      try {
        myComp.accident();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    System.out.println(myComp);
  }
}
