package model;

/**
 * A object class to simulate an employee
 * @author Christopher Nottingham and Ethan Koop 
 *
 */
public class Employee {
  private int empNo;//the employee number
  private String empName;// the employee name
  private String department;// the employee's department
  private char type; // the employee's type
  private double payRate;// the employees pay rate
  private double maxHours;// the employees max hours
  private double grossPay;//the employees gross pay



  

  /**
   * @author Christopher Nottingham
   *  Default  Constructor
   * @param empNo - Employee Number
   * @param empName - Employee Name
   * @param department - The Employee's Department
   * @param type - The type of Employee
   * @param payRate - The Employee's Pay Rate
   * @param maxHours - The max Hours the employee can work for
   */
  public Employee(int empNo, String empName, String department, char type, double payRate,
      double maxHours) {
    super();
    this.empNo = empNo;
    this.empName = empName;
    this.department = department;
    this.type = type;
    this.payRate = payRate;
    this.maxHours = maxHours;
  }



  /**
   * @author Christopher Nottingham 
   * No argument constructor
   */
  public Employee() {
    setDepartment(null);
    setEmpName(null);
    setEmpNo(0);
    setMaxHours(0);
    setPayRate(0);
    setType('n');
  }

  /**
   * @author Christopher Nottingham 
   * Constructor to make copy of other employee
   * @param copyEmployee - The employee that is to be copied
   * 
   */
  public Employee(char type, double payRate, double maxHours) {
    this.type = type;
    this.payRate = payRate;
    this.maxHours = maxHours;

  }

  /**
   * @author Christopher Nottingham
   *  A method to get the employee number
   * @return the empNo
   */
  public int getEmpNo() {
    return empNo;
  }

  /**
   * @author Christopher Nottingham
   *  A method to set a employee's new number
   * @param empNp the new employee name
   */
  public void setEmpNo(int empNp) {
    this.empNo = empNo;
  }

  /**
   * @author Christopher Nottingham
   *  A method to get the employee name
   * @return the empName
   */
  public String getEmpName() {
    return empName;
  }

  /**
   * @author Christopher Nottingham 
   * A method to set a new employee name
   * @param empName the empName to set
   */
  public void setEmpName(String empName) {
    this.empName = empName;
  }

  /**
   * @author Christopher Nottingham
   *  A method to get an employee's department
   * @return the department
   */
  public String getDepartment() {
    return department;
  }

  /**
   * @author Christopher Nottingham 
   * A method to change an employee to a different department
   * @param department the department to set
   */
  public void setDepartment(String department) {
    this.department = department;
  }

  /**
   * @author Christopher Nottingham 
   * A method to get the type of employee C = Contract, S = Salaried, H= Hourly
   * @return the employee type
   */
  public char getType() {
    return type;
  }

  /**
   * @author Christopher Nottingham 
   * A method to set the employee to a diffrent type
   * @param type  - the type to set
   */
  public void setType(char type) {
    this.type = type;
  }

  /**
   * @author Christopher Nottingham 
   * A method to get the pay rate of the employee
   * @return the payRate
   */
  public double getPayRate() {
    return payRate;
  }

  /**
   * @author Christopher Nottingham
   *  A method to set a new pay rate of an employee
   * @param payRate - the payRate to set
   */
  public void setPayRate(double payRate) {
    this.payRate = payRate;
  }

  /**
   * @author Christopher Nottingham
   *  A method to get the max hours of a current employee
   * @return the maxHours
   */
  public double getMaxHours() {
    return maxHours;
  }

  /**
   * @author Christopher Nottingham 
   * A method to set an employee's new max hours
   * @param maxHours- the new max hours
   */
  public void setMaxHours(int maxHours) {
    this.maxHours = maxHours;
  }



  /**
   * @author Ethan Koop and Christopher Nottingham 
   * A method to calculate the gross pay of an
   * employee
   * @param maxHours - set by employee type
   * @return the pre-tax pay
   */
  public double calcGrossPay() {

    double otHours;
    double otPay;

    switch (getType()) {
      case 'S':
        grossPay = getPayRate() / 52;
        break;

      case 'H':
        if (getMaxHours() <= 40) {
          grossPay = getPayRate() * 40;
        } else if (getMaxHours() > 40 && getMaxHours() <= 60) {
          otHours = getMaxHours() - 40;
          otPay = otHours * (getPayRate() * 1.5);
          grossPay = (40 * getPayRate()) + otPay;
        }
      case 'C':
        grossPay = getPayRate() * getMaxHours();

    }

    return grossPay;
  }



  /**
   * @author Christopher Nottingham 
   * Method calculates the union dues of hourly employees A method to
   * calcualte the Union dues of an Hourly employee
   */
  public double calcUnionDues(double gross) {
    return gross * 0.01;

  }

  /**
   * @author Christopher Nottingham 
   * A method to calculate the withholding tax of any employee
   * @param gross - the pre-taxed income
   * @return pay minus federal tax
   */
  public double calcWithhold(double gross) {

    if (gross < 1000) {
      return gross * 0.075;

    } else if (gross >= 1000 && gross < 2000) {
      return gross * 0.12;

    } else {
      return gross * 0.17;
    }

  }


  /**
   ** @author Christopher Nottingham 
   *Returns pay after deductions and taxes A method to get the net
   *pay of an employee
   * @return the employee's net pay
   */
  public double calcNetPay() {
    calcGrossPay();
    double netPay;

    if (getType() == 'S') {

      netPay = grossPay - calcWithhold(grossPay) - calcExtHealth(grossPay) - calcCPP(grossPay)
          - calcEI(grossPay);
    } else if (getType() == 'C') {

      netPay = grossPay - calcWithhold(grossPay) - calcCPP(grossPay) - calcEI(grossPay);

    } else {
      netPay = grossPay - calcWithhold(grossPay) - calcCPP(grossPay) - calcEI(grossPay)
          - calcUnionDues(grossPay);

    }

    return netPay;

  }


  /**
   * @author Christopher Nottingham 
   * A method to see if employee share the same employee number
   * @param otherEmp - the employee that you are checking against
   * @return a integer statement showing comparability
   */
  public int compareTo(Employee otherEmp) {

    if (this.empNo < otherEmp.getEmpNo()) {
      //System.out.println("The employee number of "+ otherEmp.getEmpNo() + " is bigger than employee number " + this.empNo);
      return -1;

    } else if (this.empNo == otherEmp.getEmpNo()) {
    	 //System.out.println("The employee number of "+ otherEmp.getEmpNo() + " is equal to employee number " + this.empNo);
      return 0;

    } else {
    	// System.out.println("The employee number of "+ otherEmp.getEmpNo() + " is less than employee number " + this.empNo);
      return 1;
    }


  }



  /**
   * Author: Ethan koop 
   * This method is used to calculate the CPP Deduction.
   * 
   * @param grossPay gross weekly pay of employees before taxes.
   * @return CPP deduction
   */
  public double calcCPP(double grossPay) {
    double cppDed;
    cppDed = grossPay * 0.0475;
    return cppDed;
  }

  /**
   * Author: Ethan koop 
   * This method is used to calculate the EI Deduction.
   * 
   * @param grossPay gross weekly pay of employees before taxes.
   * @return EI deduction
   */
  public double calcEI(double grossPay) {
    double eiDed;

    eiDed = grossPay * 0.018;

    return Math.round(eiDed);
  }

  /**
   * Author: Ethan koop 
   * This method is for calculating the extended health benefits for hourly and
   * salary employees.
   * 
   * @param grossPay gross weekly pay of employee before taxes.
   * @return Extended Health Deduction
   */
  public double calcExtHealth(double grossPay) {
    double extDed = 0;

    if (type == 'S') {
      extDed = grossPay * 0.013;

    } else if (type == 'H') {
      extDed = grossPay * 0.013;
    }

    return extDed;
  }

  /**
   * Author: Ethan Koop Print method used to print employee information
   */
  public void printEmpData(Employee aEmp) {
    System.out.println("Employee Number: " + aEmp.getEmpNo());
    System.out.println("Employee Name:   " + aEmp.getEmpName());
    if (getType() == 'S') {
      System.out.println("Employee Type:   " + "Salary");
    } else if (getType() == 'H') {
      System.out.println("Employee Type:   " + "Hourly");
    } else if (getType() == 'C') {
      System.out.println("Employee Type:   " + "Consultant");
    }
    System.out.println("Employee Department:  " + aEmp.getDepartment());

    System.out.println("Employee Pay Rate:  " + aEmp.getPayRate());

    System.out.println("Employee Hours:  " + aEmp.getMaxHours());


    System.out.println("Employee Net Pay:  " + aEmp.calcNetPay());


    System.out.println();
  }
}
