package TM4Collection.Project1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeRegister {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character

        // Use an ArrayList with Generics to store Employee objects
        ArrayList<Employee> employeeList = new ArrayList<>();

        // Loop to collect details for each employee
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter Employee " + (i + 1) + " Details:");

            System.out.print("Enter the Firstname: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter the Lastname: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter the Mobile: ");
            String mobile = scanner.nextLine();

            System.out.print("Enter the Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter the Address: ");
            String address = scanner.nextLine();

            // Create a new Employee object and add it to the list
            employeeList.add(new Employee(firstName, lastName, mobile, email, address));
        }

        // Sort the list based on the compareTo method in the Employee class
        Collections.sort(employeeList);

        // Display the sorted employee list
        System.out.println("\nEmployee List:");

        // Print the header using the specified format
        System.out.format("%-15s %-15s %-15s %-30s %-15s\n", "FirstName", "LastName", "MobileNumber", "Email", "Address");

        // Loop through the sorted list and print each employee's details
        for (Employee emp : employeeList) {
            System.out.format("%-15s %-15s %-15s %-30s %-15s\n",
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getMobileNumber(),
                    emp.getEmail(),
                    emp.getAddress());
        }

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}