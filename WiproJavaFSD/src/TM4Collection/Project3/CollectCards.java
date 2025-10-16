package TM4Collection.Project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CollectCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A HashSet is used because it only stores unique elements.
        // Our custom equals() and hashCode() in the Card class ensure uniqueness is based on the symbol.
        Set<Card> cardSet = new HashSet<>();
        int cardCount = 0;

        // Loop until 4 unique symbols are collected.
        while (cardSet.size() < 4) {
            System.out.println("Enter a card :");
            char symbol = scanner.next().charAt(0);
            int number = scanner.nextInt();

            // The add method will only increase the set's size if the card's symbol is new.
            cardSet.add(new Card(symbol, number));
            cardCount++;
        }

        System.out.println("\nFour symbols gathered in " + cardCount + " cards.");
        System.out.println("Cards in Set are :");

        // To sort the cards, we convert the Set to a List.
        List<Card> sortedCards = new ArrayList<>(cardSet);
        Collections.sort(sortedCards);

        // Print the sorted cards.
        for (Card card : sortedCards) {
            System.out.println(card);
        }

        scanner.close();
    }
}