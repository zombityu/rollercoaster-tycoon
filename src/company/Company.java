package company;

import advertising.Advertising;
import buildings.Building;
import employee.Accountant;
import employee.Employee;
import employee.Maintenance;

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

  public boolean build(Building building) {
    boolean isContain = false;
    if(buildings.size() > 0){
      for (Building games: buildings) {
        if (games.getName().equals(building.getName())) {
          isContain = true;
          break;
        }
      }
      if (!isContain) {
        this.setMoney(this.getMoney()-building.getCost());
        buildings.add(building);
      } else {
        return false;
      }
    } else {
      this.setMoney(this.getMoney()-building.getCost());
      buildings.add(building);
    }

    return true;
  }

  public void development(Building building){
    if(building.getLevelOfDevelopment() < 10){
      building.setCost(building.getCost()*building.getLevelOfDevelopment());
      this.setMoney(this.getMoney()-building.getCost());
      building.setProfit(building.getProfit()+(building.getProfit()/building.getLevelOfDevelopment()));
      building.setLevelOfDevelopment(building.getLevelOfDevelopment()+1);
    } else {
      System.out.println("You reached the maximum development");
    }
  }

  public void orderAdvertising(Advertising advertising){
    this.setMoney(this.getMoney()- advertising.getCost());
    advertising.setActive(true);
    advertisings.add(advertising);
  }

  public void accident(){
    Random rand = new Random();
    double probability = rand.nextInt(100);
    double probabilityBuildings = 0;
    Maintenance maintenance;
    Accountant accountant = null;
    
    if(employees.size() > 0){
      for (Employee employee : employees) {
        if (employee instanceof Maintenance) {
          maintenance = (Maintenance) employee;
          probabilityBuildings = probability - maintenance.getReduceProbability();
        } else {
          accountant = (Accountant) employee;
        }
      }
    }
    
    for (Building building :buildings) {
      if(probabilityBuildings <= building.getProbability()){
        this.setMoney(this.getMoney()-building.getAccidentCost());
        this.setVisitor(this.getVisitor()*(1-building.getVisitorDecrease()));
      }
    }
    if((this.level.equals("easy") && probability <= 90) || (this.level.equals("normal") && probability <= 1.5) ||
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
      this.setMoney(this.getMoney()-lost);
      System.out.println("The tax authority was fined");
    }
    if(this.getMoney() <= 0){
      System.out.println("Lost your money! Game Over");
    }
  }

  public void employ(Employee employee){
    employees.add(employee);
  }

  public void fire(Employee employee){
    employees.remove(employee);
  }

  public void endOfTheDay(){
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
      if(advertising.getPeriod() == 0){
        advertising.setActive(false);
        advertising.setPeriodCounter(advertising.getPeriod());
      }
      if(!advertising.isActive()){
        advertising.regenerate();
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
    this.visitor = visitor;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public List<Building> getBuildings() {
    return buildings;
  }

  public void setBuildings(List<Building> buildings) {
    this.buildings = buildings;
  }

  public int getDays() {
    return days;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return "My company name is " + this.name + ". "+this.level + " level. We have "+this.visitor+"" +
            " visitors and "+ this.money+" fabatka . "+getBuildings();

  }
}
