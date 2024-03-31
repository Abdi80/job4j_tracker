package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {

    @Test
    public void when4Suit3Value() {
        List<Card> expected = Arrays.asList(
                new Card(Suit.Diamonds, Value.V_6),
                new Card(Suit.Diamonds, Value.V_7),
                new Card(Suit.Diamonds, Value.V_8),
                new Card(Suit.Hearts, Value.V_6),
                new Card(Suit.Hearts, Value.V_7),
                new Card(Suit.Hearts, Value.V_8),
                new Card(Suit.Spades, Value.V_6),
                new Card(Suit.Spades, Value.V_7),
                new Card(Suit.Spades, Value.V_8),
                new Card(Suit.Clubs, Value.V_6),
                new Card(Suit.Clubs, Value.V_7),
                new Card(Suit.Clubs, Value.V_8)
        );
        List<Card> result = Deck.getDeck();
        assertThat(result).hasSameElementsAs(expected);
    }
}