import buildings.Building;
import buildings.Carousel;
import buildings.CottonCandyVendor;
import company.Company;

public class Main {
  public static void main(String[] args) {
    Company myComp = new Company("nagycirkusz","easy");

    Building cotton = new CottonCandyVendor(myComp.getLevel());
    Building carousel1 = new Carousel(myComp.getLevel());

    myComp.build(cotton);
    myComp.build(cotton);
    myComp.build(carousel1);

    for (Building building: myComp.getBuildings()) {
      System.out.println(building.getName()+" "+building.getCost()+" "+building.getProfit());
    }
  }
}
