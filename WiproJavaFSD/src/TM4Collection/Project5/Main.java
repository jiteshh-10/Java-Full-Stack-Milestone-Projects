package TM4Collection.Project5;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A TreeSet automatically keeps elements sorted and unique
        // according to the compareTo method in the Box class.
        Set<Box> boxSet = new TreeSet<>();

        System.out.println("Enter the number of Box");
        int numBoxes = scanner.nextInt();

        for (int i = 1; i <= numBoxes; i++) {
            System.out.println("\nEnter the Box " + i + " details");

            System.out.println("Enter Length");
            double length = scanner.nextDouble();

            System.out.println("Enter Width");
            double width = scanner.nextDouble();

            System.out.println("Enter Height");
            double height = scanner.nextDouble();

            // Create a new Box and add it to the set.
            // The set will handle checking for duplicates automatically.
            boxSet.add(new Box(length, width, height));
        }

        System.out.println("\nUnique Boxes in the Set are");
        for (Box box : boxSet) {
            System.out.println(box);
        }

        scanner.close();
    }
}
