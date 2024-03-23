package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class DeffExecution {
    public static void main(String[] args) {
        String[] names = {"Ivan", "Petr"};
        Comparator<String> comparator = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, comparator);
    }
}
