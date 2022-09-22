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
	public Employee(int empNo, String empName, String department, char type, double payRate, double maxHours) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.department = department;
		this.type = type;
		this.payRate = payRate;
		this.maxHours = maxHours;
	}

	

	/**
	 * No argument consstrucotr 
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
	 * Copy constructor
	 * @param copyEmployee
	 * 
	 */
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

	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}

	/**
	 * * @author Ethan Koop and Christopher Nottingham
	 * @param maxHours - set by employee typw
	 * @return the pre-tax pay
	 */
	public double calcGrossPay(int maxHours) {

		double otHours;
		double otPay;

		switch (type) {
		case 'S':
			grossPay = payRate / 52;
			break;

		case 'H':
			if (maxHours <= 40) {
				grossPay = payRate * 40;
			} else if (maxHours > 40 && maxHours <= 60) {
				otHours = maxHours - 40;
				otPay = otHours * (payRate * 1.5);
				grossPay = (40 * payRate) + otPay;
			}
		case 'C':
			grossPay = payRate * maxHours;

		}
		return grossPay;
	}

	

	

	

	/**
	 *  @author Christopher Nottingham
	 * Method calculates the union dues of hourly employees 
	 */
	public double calcUnionDues(double gross) {
		return gross * 0.01;

	}

	/**
	 * * @author Christopher Nottingham
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
 * Returns pay after deductions and taxes
 * @return
 */
	public double calcNetPay() {
	double netPay;

		if (type == 'S') {
			
			netPay =  grossPay - (calcWithhold(grossPay) + calcExtHealth(grossPay) + calcCPP(grossPay) + calcEI(grossPay));
		} else if (type == 'C') {
			
			netPay =  grossPay - (calcWithhold(grossPay) + calcCPP(grossPay) + calcEI(grossPay));
				
		} else {
			netPay = grossPay - (calcWithhold(grossPay) + calcCPP(grossPay) + calcEI(grossPay)+calcUnionDues(grossPay));

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
			return -1;

		} else if (this.empNo == otherEmp.getEmpNo()) {
			return 0;

		} else {
			return 1;
		}

		// TODO Auto-generated method stub

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
