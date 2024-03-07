package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void whenIncreaseSort() {
        List<Item> expected = Arrays.asList(new Item(5, "A"),
                                            new Item(8, "B"),
                                            new Item(1, "C"),
                                            new Item(4, "D"));
        List<Item> items = Arrays.asList(new Item(4, "D"),
                                        new Item(5, "A"),
                                        new Item(1, "C"),
                                        new Item(8, "B"));
        items.sort(new ItemAscByName());
        assertThat(items.equals(expected)).isTrue();
    }

    @Test
    void whenDecreaseSort() {
        List<Item> expected = Arrays.asList(new Item(5, "D"),
                                            new Item(8, "C"),
                                            new Item(1, "B"),
                                            new Item(4, "A"));
        List<Item> items = Arrays.asList(new Item(4, "D"),
                                        new Item(5, "A"),
                                        new Item(1, "C"),
                                        new Item(8, "B"));
        items.sort(new ItemDescByName());
        assertThat(items.equals(expected)).isTrue();
    }
}