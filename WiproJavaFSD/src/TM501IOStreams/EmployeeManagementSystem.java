package TM501IOStreams;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Load existing employees from the file at the start
        ArrayList<Employee> employees = loadEmployeesFromFile();

        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline

            switch (choice) {
                case 1:
                    addEmployee(scanner, employees);
                    break;
                case 2:
                    displayAllEmployees(employees);
                    break;
                case 3:
                    System.out.println("Exiting the System");
                    scanner.close();
                    return; // Exit the main method
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner, ArrayList<Employee> employees) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        employees.add(new Employee(id, name, age, salary));
        saveEmployeesToFile(employees); // Save the updated list to the file
        System.out.println("Employee added successfully.");
    }

    private static void displayAllEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("\n----Report----");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("----End of Report----");
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<Employee> loadEmployeesFromFile() {
        ArrayList<Employee> employees = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                employees = (ArrayList<Employee>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading data from file: " + e.getMessage());
            }
        }
        return employees;
    }

    private static void saveEmployeesToFile(ArrayList<Employee> employees) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }
}
