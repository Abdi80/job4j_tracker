package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueTextTest {

    @Test
    void isEquals() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        assertThat(uniqueText.isEquals(origin, text)).isTrue();
    }

    @Test
    public void isNotEquals() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(uniqueText.isEquals(origin, text)).isFalse();
    }

    @Test
    void isEqualsChangeOrder() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "My mouse eats a cat";
        assertThat(uniqueText.isEquals(origin, text)).isTrue();
    }

    @Test
    void isNotEqualsWithExtraOneWord() {
        UniqueText uniqueText = new UniqueText();
        String origin = "My cat eats a mouse";
        String text = "My cat eats a tasty mouse";
        assertThat(uniqueText.isEquals(origin, text)).isFalse();
    }
}