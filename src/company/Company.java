package company;

import advertising.Advertising;
import buildings.Building;
import buildings.CottonCandyVendor;
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
  private static int days;

  public Company(String name, String level) {
    this.name = name;
    this.level = level;
    this.money = 150000;
    this.visitor = 10;
    buildings = new ArrayList<>();
    employees = new ArrayList<>();
    this.days = 0;
  }

  public void build(Building building) throws Exception {
    boolean isContain = false;
    if(buildings.size() > 0){
      for (Building games: buildings) {
        if(games.getName().equals(building.getName())){
          isContain = true;
        }
      }
      if (!isContain) {
        this.setMoney(this.getMoney()-building.getCost());
        buildings.add(building);
      }
    } else {
      this.setMoney(this.getMoney()-building.getCost());
      buildings.add(building);
    }
  }

  public void development(Building building){
    if(building.getLevelOfDevelopment() < 10){
      building.setCost(building.getCost()*building.getLevelOfDevelopment());
      this.setMoney(this.getMoney()-building.getCost());
      building.setProfit(building.getProfit()+(building.getProfit()/building.getLevelOfDevelopment()));
      building.setLevelOfDevelopment(building.getLevelOfDevelopment()+1);
    } else {

    }
  }

  public void orderAdvertising(Advertising advertising){

    this.setMoney(this.getMoney()- advertising.getCost());

  }

  public void accident() throws Exception{
    Random rand = new Random();
    double probability = rand.nextInt(100);
    double probabilityBuildings = 0;
    Maintenance maintenance = null;
    Accountant accountant = null;
    
    if(employees.size() > 0){
      for (int i=0; i<employees.size(); i++){
        if(employees.get(i) instanceof Maintenance ){
          maintenance = (Maintenance) employees.get(i);
        } else {
          accountant = (Accountant) employees.get(i);
        }
      }
      probabilityBuildings = probability - maintenance.getReduceProbability();
    }
    
    for (Building building :buildings) {
      if(probabilityBuildings <= building.getProbability()){
        this.setMoney(this.getMoney()-building.getAccidentCost());
        this.setVisitor(this.getVisitor()*(1-building.getVisitorDecrease()));
        if(this.getMoney() <= 0){
          throw new Exception("Lost your money! Game Over");
        }
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
  }

  public void employ(Employee employee){
    employees.add(employee);
  }

  public void fire(Employee employee){
    employees.remove(employee);
  }

  public void endOfTheDay(){
    this.days++;
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
