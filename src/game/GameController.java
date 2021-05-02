package game;

import advertising.*;
import buildings.*;
import company.Company;
import employee.Accountant;
import employee.Employee;
import employee.Maintenance;
import exceptions.GameOver;

import java.util.Scanner;

public final class GameController {
  Scanner sc = new Scanner(System.in);
  String answer = "";

  public void play() throws GameOver {
    System.out.println("Hello my dear! Welcome in our Roller Coaster Simulation!!");
    System.out.println("Please enter your company name:");
    String companyName = sc.nextLine();
    Company myComp = null;
    boolean isBreak = true;

    while(isBreak){
      System.out.println("And please my lord choose a difficulty level:(easy, normal, hard)");
      String difficultyLevel = sc.nextLine();
      switch (difficultyLevel){
        case "easy":
        case "normal":
        case "hard":
          myComp = new Company(companyName, difficultyLevel);
          isBreak = false;
          break;
        default:
          wrongCommand();
      }
    }

    while (myComp.getMoney() > 0) {
        System.out.println(myComp.getDays() + ". day Good Morning...");
        System.out.println("Do you want to employ a special workforce? Yes or No ?");
        answer = sc.nextLine();
        if (answer.equals("yes")) {
          employ(sc, myComp);
        }
        choose(myComp, sc);
    }
    throw new GameOver();
  }



  private void choose(Company myComp, Scanner sc) throws GameOver {
    boolean isBreak = true;
    while (isBreak) {
      System.out.println("Choose what you want to do? (build, develop, advertising order, info or end of the day)");
      String choose = sc.nextLine();
      switch (choose) {
        case "build":
          build(myComp, sc);
          break;
        case "develop":
          develop(myComp);
          break;
        case "advertising order":
          order(myComp);
          break;
        case "info":
          myComp.info();
          break;
        case "end of the day":
          myComp.endOfTheDay();
          if(myComp.getEmployees().size() > 0){
            fire(myComp);
          }
          isBreak = false;
          break;
        default:
          wrongCommand();
      }
    }
  }

  private void fire(Company myComp) {
    boolean isBreak = true;
    while(isBreak){
      System.out.println("Do you want to fire the employees? yes or no ");
      answer = sc.nextLine();
      if(answer.equals("yes")){
        System.out.println("Which employee do you want to fire?");
        for (int i=0; i<myComp.getEmployees().size(); i++){
          System.out.println(myComp.getEmployees().get(i).getName());
        }
        System.out.println("both");
        answer = sc.nextLine();
        if(answer.equals("Maintenance") || answer.equals("Accountant")){
          for (int j=0; j<myComp.getEmployees().size(); j++){
            if(myComp.getEmployees().get(j).getName().equals(answer)){
              myComp.fire(myComp.getEmployees().get(j));
              isBreak = false;
            }
          }
        } else if(answer.equals("both")) {
          myComp.getEmployees().clear();
          isBreak = false;
        } else {
          wrongCommand();
        }
      } else if(answer.equals("no")){
        break;
      } else {
        wrongCommand();
      }
    }
  }

  private void order(Company myComp){
    Advertising flyer = new Flyer(myComp.getLevel());
    Advertising newsPaper = new NewspaperAd(myComp.getLevel());
    Advertising billboard = new Billboard(myComp.getLevel());
    Advertising tvAdvertisement = new TVAdvertisement(myComp.getLevel());
    Advertising adSense = new AdSense(myComp.getLevel());
    boolean isBreak = true;


    while(isBreak){
      System.out.println();
      System.out.println("Which ad would you like to order?");
      System.out.println();
      System.out.println(flyer);
      System.out.println(newsPaper);
      System.out.println(billboard);
      System.out.println(tvAdvertisement);
      System.out.println(adSense);
      answer = sc.nextLine();
      switch (answer){
        case "Flyer":
          myComp.orderAdvertising(flyer);
          isBreak = false;
          break;
        case "Newspaper Ad":
          myComp.orderAdvertising(newsPaper);
          break;
        case "Billboard":
          myComp.orderAdvertising(billboard);
          isBreak = false;
          break;
        case "TVAdvertisement":
          myComp.orderAdvertising(tvAdvertisement);
          isBreak = false;
          break;
        case "AdSense":
          myComp.orderAdvertising(adSense);
          isBreak = false;
          break;
        default:
          wrongCommand();
      }
    }
  }

  private void develop(Company myComp){
    if(myComp.getBuildings().size() > 0){
      System.out.println("Which building do you want to develop?");
      for (int i=0; i<myComp.getBuildings().size(); i++){
        System.out.println(myComp.getBuildings().get(i).getName());
      }
      answer = sc.nextLine();
      for(int j=0; j<myComp.getBuildings().size(); j++){
        if(myComp.getBuildings().get(j).getName().equals(answer)){
          myComp.development(myComp.getBuildings().get(j));
        } else {
          wrongCommand();
        }
      }
    } else {
      System.out.println("You have nothing to develop!");
    }
  }

  private void build(Company myComp, Scanner sc){
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
          myComp.build(candy);
          isBreak = true;
          break;
        case "Carousel":
          myComp.build(carousel);
          isBreak = true;
          break;
        case "BoatingLake":
          myComp.build(boatingLake);
          isBreak = true;
          break;
        case "GhostTrain":
          myComp.build(ghostTrain);
          isBreak = true;
          break;
        case "RollerCoaster":
          myComp.build(rollerCoaster);
          isBreak = true;
          break;
        default:
          wrongCommand();
      }
    }
  }

  private void employ(Scanner scanner, Company company) {
    System.out.println("A specialist worker will help reduce the chance of accidents.");
    while (true){
      System.out.println("Do you want to hire an accountant? Yes or no ");
      answer = scanner.nextLine();
      if(answer.equals("yes")){
        Employee accountant = new Accountant();
        company.employ(accountant);
        break;
      } else if(answer.equals("no")){
        break;
      } else{
        wrongCommand();      }
    }
    while(true) {
      System.out.println("How many maintainers do you want to employ?(Max 5)");
      answer = scanner.nextLine();
      int answerNum = Integer.parseInt(answer);
      if (answerNum > 0 && answerNum <= 5) {
        Employee maintance = new Maintenance(answerNum);
        company.employ(maintance);
        break;
      } else if (answerNum == 0) {
        break;
      } else {
        wrongCommand();
      }
    }
  }

  private void wrongCommand(){
    System.out.println();
    System.out.println("Sorry my friend but incorrect answer... try again");
    System.out.println();
  }
}
