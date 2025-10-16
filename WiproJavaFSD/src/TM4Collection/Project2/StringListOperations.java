package TM4Collection.Project2;

import java.util.ArrayList;
import java.util.Scanner;

public class StringListOperations {

    public static void main(String[] args) {
        // Use an ArrayList to store the list of strings
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // An infinite loop to keep the menu running until the user chooses to exit
        while (true) {
            // Display the menu options
            System.out.println("\n1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // This is important to consume the newline character left by nextInt()

            // Use a switch statement to perform the chosen operation
            switch (choice) {
                case 1:
                    System.out.print("Enter the item to be inserted: ");
                    String itemToInsert = scanner.nextLine();
                    list.add(itemToInsert);
                    System.out.println("Inserted successfully");
                    break;

                case 2:
                    System.out.print("Enter the item to search : ");
                    String itemToSearch = scanner.nextLine();
                    if (list.contains(itemToSearch)) {
                        System.out.println("Item found in the list.");
                    } else {
                        System.out.println("Item not found in the list.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the item to delete : ");
                    String itemToDelete = scanner.nextLine();
                    if (list.remove(itemToDelete)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Item does not exist.");
                    }
                    break;

                case 4:
                    if (list.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        System.out.println("The Items in the list are :");
                        for (String item : list) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program...");
                    scanner.close(); // Close the scanner to free up resources
                    return; // Exit the main method, terminating the program

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
