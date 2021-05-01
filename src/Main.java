import advertising.Advertising;
import advertising.Flyer;
import buildings.*;
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
    String answer;

    while(myComp.getMoney() > 0){
      try {
        System.out.println(myComp.getDays()+". day Good Morning...");
        System.out.println("Do you want to employ a special workforce? Yes or No ?");
        answer = sc.nextLine();
        if(answer.equals("yes")){
          employ(sc, myComp);
        }
        choose(myComp, sc);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private static void choose(Company myComp, Scanner sc) {
    boolean isBreak = true;
    while (isBreak) {
      System.out.println("Choose what you want to do? (build, develop, advertising order or end of the day)");
      String choose = sc.nextLine();
      switch (choose) {
        case "build":
          build(myComp, sc);
          break;
        case "develop":
          break;
        case "advertising order":
          break;
        case "end of the day":
          myComp.endOfTheDay();
          isBreak = false;
          break;
        default:
          System.out.println("Sorry my friend but incorrect answer... try again");
      }
    }
  }

  private static void build(Company myComp, Scanner sc) {
    Building candy =new CottonCandyVendor(myComp.getLevel());
    Building carousel =new Carousel(myComp.getLevel());
    Building boatingLake =new BoatingLake(myComp.getLevel());
    Building ghostTrain =new GhostTrain(myComp.getLevel());
    Building rollerCoaster =new RollerCoaster(myComp.getLevel());
    boolean isBreak = false;
    boolean message = false;

    while(!isBreak){
      System.out.println("Which building do you want to build?");
      System.out.println(candy);
      System.out.println(carousel);
      System.out.println(boatingLake);
      System.out.println(ghostTrain);
      System.out.println(rollerCoaster);

      String choose = sc.nextLine();
      switch (choose){
        case "CottonCandyVendor":
          message = myComp.build(candy);
          break;
        case "Carousel":
          message = myComp.build(carousel);
          break;
        case "BoatingLake":
          message = myComp.build(boatingLake);
          break;
        case "GhostTrain":
          message = myComp.build(ghostTrain);
          break;
        case "RollerCoaster":
          message = myComp.build(rollerCoaster);
          break;
        default:
          System.out.println("Sorry my friend but incorrect answer... try again");
      }
      if(message){
        System.out.println("Construction completed successfully! ");
        isBreak = true;
      } else {
        System.out.println("You have already built this building! :(");
      }
    }
  }

  private static void employ(Scanner scanner, Company company) {
    System.out.println("A specialist worker will help reduce the chance of accidents.");
    while (true){
      System.out.println("Do you want to hire an accountant? Yes or no ");
      String answeri = scanner.nextLine();
      if(answeri.equals("yes")){
        Employee accountant = new Accountant();
        company.employ(accountant);
        break;
      } else if(answeri.equals("no")){
        break;
      } else{
        System.out.println("Sorry my friend but incorrect answer... try again");
      }
    }
    while(true) {
      System.out.println("How many maintainers do you want to employ?(Max 5)");
      int answer = scanner.nextInt();
      if (answer > 0 && answer <= 5) {
        Employee maintance = new Maintenance(answer);
        company.employ(maintance);
        break;
      } else if (answer == 0) {
        break;
      } else {
        System.out.println("Sorry my friend but incorrect answer... try again");
      }
    }
  }
}
