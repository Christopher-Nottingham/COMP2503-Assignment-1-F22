package application;

import controller.DatabaseManager;

public class AppDriver {
  public static void main(String[] args) {
    DatabaseManager db = new DatabaseManager();
    db.loabDB();
  }
}


