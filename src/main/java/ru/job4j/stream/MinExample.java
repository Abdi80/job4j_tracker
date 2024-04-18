package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 8, 6, 7, 5);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get());

    }
}

class MinExamplePerson {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 8, 6, 7, 5);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get());

    }
}


