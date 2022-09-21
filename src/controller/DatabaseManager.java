package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Employee;

public class DatabaseManager {

  private File database;
  private final String DB_PATH = "res/Employee Test Data.txt";
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
        // putting elements by empty staces
        String[] splitInfo = employee.split(" ");
        // reading whole line
        // String currentEmployee = fileReader.nextLine();;

        // Getting data from file and putting into Array
        int theEmpNo = Integer.parseInt(splitInfo[0]);
        String theEmpName = splitInfo[1];
        String theDepartment = splitInfo[2];;
        Character theType = splitInfo[3].charAt(0);;
        double thePayRate = Double.parseDouble(splitInfo[4]);
        double theMaxHours = Double.parseDouble(splitInfo[5]);

        // Employee theNewEmployee = new Employee(theEmpNo, theEmpName, theDepartment, 0,
        // thePayRate,
        // 0)


        Employee theNewEmployee =
            new Employee(theEmpNo, theEmpName, theDepartment, theType, thePayRate, theMaxHours);

        System.out.println(theNewEmployee.getDepartment());
        employeeDB.add(theNewEmployee);
      }



    } catch (FileNotFoundException e2) {
      // TODO Auto-generated catch block
      e2.printStackTrace();
    }



    // String currentToy; // String variable containing current line data from
    //
    // Toy newInventory; // Toy variable that will contain the various created Toys
    //
    // if (database.exists()) {// if the file exits then continue or else create it
    // Scanner stockReader = new Scanner(database);// Scanner to read each line
    //
    // while (stockReader.hasNextLine()) {// While the scanner can still see a line
    // String serialNumber = stockReader.nextLine();// Creating a string to save and analyze it
    // currentToy = serialNumber; // Setting the toy object equal to string
    // serialNumber = serialNumber.substring(0, 10);// getting 10-digit serial num for analysis
    //
    // if (!currentToy.isEmpty() || !currentToy.isBlank()) {// while the toy is not empty nor blank

    // for (String word : )
    // try {
    // stockReader = new Scanner(database);
    // System.out.println(stockReader.nextLine());

    //
    // } catch (FileNotFoundException e1) {
    // // TODO Auto-generated catch block
    // e1.printStackTrace();
    // }
    //
    //
    // employeeDB = new ArrayList<Employee>();
    // database = new File(DB_PATH);
    // try {
    // fileReader = new Scanner(database);
    // String emp = fileReader.nextLine();
    // } catch (FileNotFoundException e1) {
    // // TODO Auto-generated catch block
    // e1.printStackTrace();
    // }
    //
    //
    //
    // //
    // try {
    // fileReader = new Scanner(database);
    // while (fileReader.hasNextLine()) {
    // Employee newEmployee;
    //
    //
    //
    // }
    // } catch (FileNotFoundException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    //


  }



}
