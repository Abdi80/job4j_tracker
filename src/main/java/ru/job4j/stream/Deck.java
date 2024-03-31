package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }
}

public class Deck {
    public static void main(String[] args) {
        List<Card> cards = getDeck();
        System.out.println(cards);
    }

    public static List<Card> getDeck() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .collect(Collectors.toList());
    }
}