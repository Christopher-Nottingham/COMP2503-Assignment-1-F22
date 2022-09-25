package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Employee;

public class DatabaseManager {

  private File database;
  private final String DB_PATH = "res/EmployeeTestData.txt";
  private ArrayList<Employee> employeeDB;

  private Scanner fileReader;

  private Scanner stockReader;

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
        String theDepartment = splitInfo[2];;
        Character theType = splitInfo[3].charAt(0);;
        double thePayRate = Double.parseDouble(splitInfo[4]);
        double theMaxHours = Double.parseDouble(splitInfo[5]);



        Employee theNewEmployee =
            new Employee(theEmpNo, theEmpName, theDepartment, theType, thePayRate, theMaxHours);


        employeeDB.add(theNewEmployee);
        // theNewEmployee.compareTo(theNewEmployee);
      }

      for (Employee e : employeeDB) {
        e.printEmpData(e);;

      }



    } catch (FileNotFoundException e2) {
      // TODO Auto-generated catch block
      e2.printStackTrace();
    }



  }



  // public void calcuatingPay() {
  // for (Employee e : ) {
  //
  // // if (e.)
  // }
  //
  // }



}
