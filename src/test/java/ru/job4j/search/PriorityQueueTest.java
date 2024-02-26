package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriorityQueueTest {

    @Test
    public void whenHigherPrioritySecond() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent");
    }

    @Test
    public void whenHigherPriorityFirst() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("urgent", 0));
        queue.put(new Task("low", 2));
        queue.put(new Task("middle", 1));
        Task result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent");
    }

    @Test
    public void whenHigherPriorityLast() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("Low", 5));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        Task result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent");
    }

    @Test
    public void whenHigherPriorityEquals() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("Low", 5));
        queue.put(new Task("urgent", 5));
        queue.put(new Task("middle", 5));
        Task result = queue.take();
        assertThat(result.getDescription()).isEqualTo("Low");
    }
}