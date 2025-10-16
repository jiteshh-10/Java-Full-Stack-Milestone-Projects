package TM809RDBMSSQLJDBC;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        System.out.println("--- Testing Scenario 1 ---");
        System.out.println("User type for AB1001: " + userDAO.getUserType("AB1001"));

        System.out.println("\n--- Testing Scenario 2 ---");
        System.out.println("Incorrect attempts for TA1002: " + userDAO.getIncorrectAttempts("TA1002"));

        System.out.println("\n--- Testing Scenario 3 ---");
        System.out.println("Changing user type for RS1003 to Admin: " + userDAO.changeUserType("RS1003"));

        System.out.println("\n--- Testing Scenario 4 ---");
        System.out.println("Count of users with lock status 0: " + userDAO.getLockStatus());

        System.out.println("\n--- Testing Scenario 5 ---");
        System.out.println("Changing name for AB1001: " + userDAO.changeName("AB1001", "Hari Kumar"));

        System.out.println("\n--- Testing Scenario 6 ---");
        System.out.println("Changing password for all Admins: " + userDAO.changePassword("newAdminPass"));

        System.out.println("\n--- Testing Scenario 7 ---");
        UserBean user1 = new UserBean();
        user1.setId("TS1004");
        user1.setPassword("TS1004");
        user1.setName("Suresh");
        user1.setIncorrectAttempts(0);
        user1.setLockStatus(0);
        user1.setUserType("Employee");
        System.out.println("Adding user (addUser_1): " + userDAO.addUser_1(user1));

        System.out.println("\n--- Testing Scenario 8 ---");
        UserBean user2 = new UserBean();
        user2.setId("LK1005");
        user2.setPassword("LK1005");
        user2.setName("Lokesh");
        user2.setIncorrectAttempts(0);
        user2.setLockStatus(0); // Lock status is 0, so it should succeed
        user2.setUserType("Employee");
        System.out.println("Adding user (addUser_2): " + userDAO.addUser_2(user2));

        System.out.println("\n--- Testing Scenario 9 ---");
        ArrayList<UserBean> employees = userDAO.getUsers("Employee");
        System.out.println("Found " + employees.size() + " Employees:");
        for(UserBean user : employees) {
            System.out.println(user);
        }

        System.out.println("\n--- Testing Scenario 10 ---");
        ArrayList<UserBean> allUsers = userDAO.storeAllRecords();
        System.out.println("All Users in DB:");
        for(UserBean user : allUsers) {
            System.out.println(user);
        }

        System.out.println("\n--- Testing Scenario 11 ---");
        String[] allNames = userDAO.getNames();
        System.out.println("All names in DB: " + Arrays.toString(allNames));
    }
}
