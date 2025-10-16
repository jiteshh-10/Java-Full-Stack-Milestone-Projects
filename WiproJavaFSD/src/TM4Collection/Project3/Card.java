package TM4Collection.Project3;

import java.util.Objects;

public class Card implements Comparable<Card> {
    private char symbol;
    private int number;

    public Card(char symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    // Overriding toString() for easy printing of card details.
    @Override
    public String toString() {
        return symbol + " " + number;
    }

    // hashCode is overridden to base the hash only on the symbol.
    // This ensures that cards with the same symbol are grouped in the same hash bucket.
    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    // equals is overridden to consider two Card objects equal if they have the same symbol.
    // This is crucial for the Set to correctly identify unique symbols.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return symbol == card.symbol;
    }

    // compareTo is implemented to sort cards alphabetically by their symbol.
    @Override
    public int compareTo(Card other) {
        return Character.compare(this.symbol, other.symbol);
    }
}
