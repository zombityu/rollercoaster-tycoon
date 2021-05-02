package employee;

public class Employee {
  private int reduceProbability;
  private String name;

  public Employee() {
  }

  public int getReduceProbability() {
    return reduceProbability;
  }

  public void setReduceProbability(int reduceProbability) {
    this.reduceProbability = reduceProbability;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return name.equals(employee.name);
  }

}
