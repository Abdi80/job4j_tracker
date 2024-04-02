package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> result = strings
                .stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(result);
        String result2 = strings
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("By default");
         System.out.println(result2);
    }
}
