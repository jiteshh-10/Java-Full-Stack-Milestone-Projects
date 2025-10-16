package TM4Collection.Project4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GroupCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A TreeMap is used to automatically keep the symbols (keys) in alphabetical order.
        // The key is the card symbol (Character), and the value is a list of its numbers (List<Integer>).
        Map<Character, List<Integer>> cardMap = new TreeMap<>();

        System.out.println("Enter Number of Cards :");
        int numberOfCards = scanner.nextInt();

        // Loop to collect details for each card.
        for (int i = 1; i <= numberOfCards; i++) {
            System.out.println("Enter card " + i + ":");
            char symbol = scanner.next().charAt(0);
            int number = scanner.nextInt();

            // This is a concise way to add the number to the correct list.
            // If the symbol is not yet in the map, it creates a new ArrayList for it.
            // Then, it adds the number to that symbol's list.
            cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(number);
        }

        // --- Displaying the results ---

        // 1. Print all distinct symbols.
        System.out.println("\nDistinct Symbols are :");
        for (Character symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        // 2. Iterate through the map to print details for each symbol.
        // Because we used a TreeMap, the symbols will be processed in alphabetical order.
        for (Map.Entry<Character, List<Integer>> entry : cardMap.entrySet()) {
            char symbol = entry.getKey();
            List<Integer> numbers = entry.getValue();
            int sum = 0;

            System.out.println("\nCards in " + symbol + " Symbol");

            // Print each card and calculate the sum.
            for (int number : numbers) {
                System.out.println(symbol + " " + number);
                sum += number;
            }

            // Print the summary for the current symbol.
            System.out.println("Number of cards : " + numbers.size());
            System.out.println("Sum of Numbers : " + sum);
        }

        scanner.close(); // Close the scanner to prevent resource leaks.
    }
}