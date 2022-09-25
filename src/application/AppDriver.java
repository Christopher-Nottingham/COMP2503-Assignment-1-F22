package application;

import controller.DatabaseManager;
/**
 * The application class that starts the program
 * @author Christopher Nottingham
 *
 */
public class AppDriver {
  public static void main(String[] args) {
    DatabaseManager db = new DatabaseManager();
    db.loabDB();
  }
}


