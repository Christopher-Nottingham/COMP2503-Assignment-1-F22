package model;

public class Employee {
  private int empNo;
  private String empName;
  private String department;
  private char type;
  private double payRate;
  private double maxHours;
  private double grossPay;


  // normal constuctor
  /**
   * @param empNp
   * @param empName
   * @param department
   * @param type
   * @param payRate
   * @param maxHours
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


  // Employee empCopy = new Employee();

  // public Employee(int empCopyempNp, String empName, String department) {
  //
  //
  //
  // }

  // copy constructor
  public Employee() {
    setDepartment(null);
    setEmpName(null);
    setEmpNo(0);
    setMaxHours(0);
    setPayRate(0);
    setType('n');
  }

  // copy constructor
  public Employee(Employee copyEmployee) {
    empNo = copyEmployee.empNo;
    empName = copyEmployee.empName;
    department = copyEmployee.department;

  }



  /**
   * @return the empNp
   */
  public int getEmpNo() {
    return empNo;
  }


  /**
   * @param empNp the empNp to set
   */
  public void setEmpNo(int empNp) {
    this.empNo = empNo;
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
  public double getMaxHours() {
    return maxHours;
  }


  /**
   * @param maxHours the maxHours to set
   */
  public void setMaxHours(int maxHours) {
    this.maxHours = maxHours;
  }

  /**
   * Authors: Ethan and Christopher
   * This method is used to calculate the gross pay of employees
   * @param maxHours the max hours worked
   * @return weekly gross pay.
   */
  public double calcGrossPay(int maxHours) {
	  
	  double otHours;
	  double otPay;
	  
	  switch(type) {
	  case'S': //Ethan
		  getType();
		  grossPay = payRate / 52;
		  break;
		 
	  case'H': //Ethan
		  if(maxHours <=40) {
			  grossPay = payRate*40;
		  }else if (maxHours>40 && maxHours<=60) {
			  otHours = maxHours - 40;
			  otPay = otHours*(payRate*1.5);
			  grossPay = (40*payRate) + otPay;
		  }
	  }
	 return grossPay; 
  }

  /**
   * Author: Ethan
   * This method is used to calculate the CPP Deduction.
   * @param grossPay gross weekly pay of employees before taxes.
   * @return CPP deduction
   */
  public double calcCPP(double grossPay) {
	  double cppDed;
	  cppDed = grossPay*0.475;
	  return cppDed;
  }
  /**
   * Author: Ethan
   * This method is used to calculate the EI Deduction.
   * @param grossPay gross weekly pay of employees before taxes.
   * @return EI deduction
   */
  public double calcEI(double grossPay) {
	  double eiDed;
	  eiDed=grossPay*0.18;
	  
	  return eiDed;
  }
  
  /**
   * Author: Ethan
   * This method is for calculating the extended health benefits for hourly and salary employees.
   * @param grossPay gross weekly pay of employee before taxes. 
   * @return Extended Health Deduction
   */
  public double calcExtHealth(double grossPay) {
	  double extDed = 0;
	  
	  if (type == 'S') {
		  extDed = grossPay*0.13;
		  
	  }else if(type == 'H') {
		  extDed = grossPay*0.13;
	  }
	  
	  return extDed;
  }
}
