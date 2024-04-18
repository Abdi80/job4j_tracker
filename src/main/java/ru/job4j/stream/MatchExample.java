package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result = strings.stream()
                .noneMatch("Шесть"::contains);
        System.out.println(result);
        boolean result2 = strings
                .stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(result2);
        List<String> strings2 = Arrays.asList("Трижды", "Три", "Триста", "Три тысячи");
        boolean result3 = strings2
                .stream()
                .allMatch(element -> element.startsWith("Т"));
        System.out.println(result3);
    }
}
