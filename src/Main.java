import buildings.Building;
import buildings.Carousel;
import buildings.CottonCandyVendor;
import company.Company;

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

    while(myComp.getMoney() > 0){
      try {
        myComp.build(candy);
        myComp.development(candy);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    System.out.println(myComp);
  }
}
