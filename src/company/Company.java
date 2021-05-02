package company;

import advertising.Advertising;
import buildings.Building;
import employee.Accountant;
import employee.Employee;
import employee.Maintenance;
import exceptions.GameOver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {
  private String name;
  private String level;
  private int visitor;
  private int money;
  private List<Building> buildings;
  private List<Employee> employees;
  private List<Advertising> advertisings;
  private static int days;

  public Company(String name, String level) {
    this.name = name;
    this.level = level;
    this.money = 150000;
    this.visitor = 10;
    buildings = new ArrayList<>();
    employees = new ArrayList<>();
    advertisings = new ArrayList<>();
    days = 1;
  }

  public void build(Building building){
    boolean isContain = false;
    if(buildings.size() > 0){
      for (Building games: buildings) {
        if (games.getName().equals(building.getName())) {
          isContain = true;
          break;
        }
      }
      if (!isContain) {
        if(this.setMoney(this.getMoney()-building.getCost())){
          buildings.add(building);
          System.out.println("Construction completed successfully! ");
        } else {
          System.out.println("You don't have enough money");
        }
      } else {
        System.out.println("You have already built this building! :(");
      }
    } else {
      if(this.setMoney(this.getMoney()-building.getCost())) {
        buildings.add(building);
        System.out.println("Construction completed successfully! ");
      } else {
        System.out.println("You don't have enough money");
      }
    }
  }

  private void gameOver() throws GameOver {
    throw new GameOver();
  }

  public void development(Building building){
    if(building.getLevelOfDevelopment() < 10){
      building.setCost(building.getCost()*building.getLevelOfDevelopment());
      if(this.setMoney(this.getMoney()-building.getCost())) {
        building.setProfit(building.getProfit() + (building.getProfit() / building.getLevelOfDevelopment()));
        building.setLevelOfDevelopment(building.getLevelOfDevelopment() + 1);
        System.out.println("Successful development!");
      } else {
        System.out.println("You don't have enough money");
      }
    } else {
      System.out.println("You reached the maximum development!");
    }
  }

  public void orderAdvertising(Advertising advertising){
    if(this.setMoney(this.getMoney()- advertising.getCost())) {
      advertising.setActive(true);
      advertisings.add(advertising);
      System.out.println("Advertising ordered successfully!");
    } else {
      System.out.println("You don't have enough money");
    }
  }

  public void accident() throws GameOver {
    Random rand = new Random();
    double probability = rand.nextInt(100);
    double probabilityBuildings = probability;
    Maintenance maintenance;
    Accountant accountant = null;
    int fee = 0;
    
    if(employees.size() > 0){
      for (Employee employee : employees) {
        if (employee instanceof Maintenance) {
          maintenance = (Maintenance) employee;
          probabilityBuildings -= maintenance.getReduceProbability();
          fee += maintenance.getFee();
        } else {
          accountant = (Accountant) employee;
          fee += accountant.getFee();
        }
      }
      if(this.getMoney()-fee <= 0){
        gameOver();
      } else {
        this.setMoney(this.getMoney()-fee);
      }
    }
    
    for (Building building :buildings) {
      if(probabilityBuildings <= building.getProbability()){
        if(this.getMoney()-building.getAccidentCost() <= 0){
          gameOver();
        } else {
          this.setMoney(this.getMoney()-building.getAccidentCost());
        }
        this.setVisitor(this.getVisitor()*(1-building.getVisitorDecrease()));
        System.out.println(building.getAccident());
      }
    }
    if((this.level.equals("easy") && probability <= 1) || (this.level.equals("normal") && probability <= 1.5) ||
            (this.level.equals("hard") && probability <= 2)){
      int lost;
      if(this.getMoney() <= 200000){
        lost = 100000;
      } else {
        lost = (int)(this.getMoney()*0.5);
      }
      if(accountant != null){
        lost /= 2;
      }
      System.out.println("The tax authority was fined");
      if(this.getMoney()-lost <= 0){
        gameOver();
      } else {
        this.setMoney(this.getMoney()-lost);
      }
    }
  }

  public void employ(Employee employee){
    if(this.getEmployees().size() > 0){
      if(!this.getEmployees().contains(employee)){
        employees.add(employee);
      } else {
        System.out.println("You've already hired this "+employee.getName()+"!");
      }
    } else {
      employees.add(employee);
    }
  }

  public void fire(Employee employee){
    employees.remove(employee);
    System.out.println("You've successfully fired the "+employee.getName());
  }

  public void endOfTheDay() throws GameOver {
    int profit = 0;
    int visitors = 0;
    for (Building building:buildings) {
      profit += (building.getProfit()*this.getVisitor());
    }

    for (Advertising advertising: advertisings) {
      if(advertising.isActive()){
        visitors += advertising.getVisitorPerDay();
        advertising.setVisitorPerDay((int)(advertising.getVisitorPerDay()*0.9));
        advertising.setPeriodCounter(advertising.getPeriodCounter()-1);
      }

      if(!advertising.isActive()){
        advertising.regenerate();
      }

      if(advertising.getPeriodCounter() == 0){
        advertising.setActive(false);
        advertising.setPeriodCounter(advertising.getPeriod());
      }
    }

    accident();

    this.setMoney(this.getMoney()+profit);
    this.setVisitor(this.getVisitor()+visitors);
    days++;
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
    if(visitor > 0){
      this.visitor = visitor;
    } else {
      this.visitor = 0;
    }
  }

  public int getMoney() {
    return money;
  }

  public boolean setMoney(int money) {
    if(money > 0){
      this.money = money;
      return true;
    }
    return false;
  }

  public List<Building> getBuildings() {
    return buildings;
  }

  public int getDays() {
    return days;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public List<Advertising> getAdvertisings() {
    return advertisings;
  }

  public void info(){
    System.out.println();
    System.out.println("Company name: " + this.name + "\nVisitors: " + this.visitor + "\nMoney: " + this.money + " fabatka");
    if(this.getBuildings().size() > 0){
      System.out.println("Buildings: ");
      for (int i=0; i<this.getBuildings().size(); i++ ){
        System.out.println(this.getBuildings().get(i).getName()+" Level: "+this.getBuildings().get(i).getLevelOfDevelopment());
      }
    } else {
      System.out.println("You didn't build anything!");
    }
    if (this.getEmployees().size() > 0){
      System.out.println("Employees: ");
      for (int j=0; j<this.getEmployees().size(); j++){
        System.out.println(this.getEmployees().get(j).getName());
      }
    }
    if(this.getAdvertisings().size() > 0){
      System.out.println("Active ads: ");
      for(int a=0; a<this.getAdvertisings().size(); a++){
        if(this.getAdvertisings().get(a).isActive()){
          System.out.println(this.getAdvertisings().get(a).getName()+" "
                            +this.getAdvertisings().get(a).getPeriodCounter()+" day(s) left" );
        }
      }
    }
  }
}
