package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Employee;

/**
 * Logic class that handles the database
 * 
 * @author Christopher Nottingham
 *
 */
public class DatabaseManager {

	private File database;
	private final String DB_PATH = "res/EmployeeTestData.txt";
	private ArrayList<Employee> employeeDB;

	private Scanner fileReader;


	/**
	 * A method to load the database with all employee's from text file
	 * 
	 * @author Christopher Nottingham
	 */
	public void loabDB() {

		employeeDB = new ArrayList<>();

		database = new File(DB_PATH);
		try {

			fileReader = new Scanner(database);

			while (fileReader.hasNextLine()) {

				String employee = fileReader.nextLine();

				String[] splitInfo = employee.split(" ");

				int theEmpNo = Integer.parseInt(splitInfo[0]);
				String theEmpName = splitInfo[1];
				String theDepartment = splitInfo[2];
				;
				Character theType = splitInfo[3].charAt(0);
				;
				double thePayRate = Double.parseDouble(splitInfo[4]);
				double theMaxHours = Double.parseDouble(splitInfo[5]);

				Employee theNewEmployee = new Employee(theEmpNo, theEmpName, theDepartment, theType, thePayRate,
						theMaxHours);

				employeeDB.add(theNewEmployee);
				// theNewEmployee.compareTo(theNewEmployee);
			}

			for (Employee e : employeeDB) {
				e.printEmpData(e);
				
			}

			System.out.println("Checking equality of employee number: " + employeeDB.get(0).getEmpNo());
			for (int i = 0; i < employeeDB.size(); i++) {
				System.out.println(employeeDB.get(i).compareTo(employeeDB.get(0)));

			}
			System.out.println();
			System.out.println("Checking equality of employee number: " + employeeDB.get(1).getEmpNo());
			for (int i = 0; i < employeeDB.size(); i++) {
				
				System.out.println(employeeDB.get(i).compareTo(employeeDB.get(1)));

			}
			System.out.println();
			System.out.println("Checking equality of employee number: " + employeeDB.get(2).getEmpNo());
			for (int i = 0; i < employeeDB.size(); i++) {
				
				System.out.println(employeeDB.get(i).compareTo(employeeDB.get(2)));

			}


		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

}
