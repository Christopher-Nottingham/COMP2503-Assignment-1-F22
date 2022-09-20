package model;

public class Employee {
  private int empNp;
  private String empName;
  private String department;
  private char type;
  private double payRate;
  private int maxHours;

  Employee empCopy = new Employee();

  public Employee(int empCopyempNp, String empName, String department) {



  }

  // copy constructor
  public Employee() {
    setDepartment(null);
    setEmpName(null);
    setEmpNp(0);
    setMaxHours(0);
    setPayRate(0);
    setType('n');
  }

  // copy constructor
  public Employee(Employee copyEmployee) {
    empNp = copyEmployee.empNp;
    empName = copyEmployee.empName;
    department = copyEmployee.department;

  }


  // normal constuctor
  /**
   * @param empNp
   * @param empName
   * @param department
   * @param type
   * @param payRate
   * @param maxHours
   */
  public Employee(int empNp, String empName, String department, char type, double payRate,
      int maxHours) {
    super();
    this.empNp = empNp;
    this.empName = empName;
    this.department = department;
    this.type = type;
    this.payRate = payRate;
    this.maxHours = maxHours;
  }


  /**
   * @return the empNp
   */
  public int getEmpNp() {
    return empNp;
  }


  /**
   * @param empNp the empNp to set
   */
  public void setEmpNp(int empNp) {
    this.empNp = empNp;
  }


  /**
   * @return the empName
   */
  public String getEmpName() {
    return empName;
  }


  /**
   * @param empName the empName to set
   */
  public void setEmpName(String empName) {
    this.empName = empName;
  }


  /**
   * @return the department
   */
  public String getDepartment() {
    return department;
  }


  /**
   * @param department the department to set
   */
  public void setDepartment(String department) {
    this.department = department;
  }


  /**
   * @return the type
   */
  public char getType() {
    return type;
  }


  /**
   * @param type the type to set
   */
  public void setType(char type) {
    this.type = type;
  }


  /**
   * @return the payRate
   */
  public double getPayRate() {
    return payRate;
  }


  /**
   * @param payRate the payRate to set
   */
  public void setPayRate(double payRate) {
    this.payRate = payRate;
  }


  /**
   * @return the maxHours
   */
  public int getMaxHours() {
    return maxHours;
  }


  /**
   * @param maxHours the maxHours to set
   */
  public void setMaxHours(int maxHours) {
    this.maxHours = maxHours;
  }



}
