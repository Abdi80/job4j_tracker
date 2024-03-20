package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftElements = left.split("/", 2);
        String[] rightElements = right.split("/", 2);
        int result = rightElements[0].compareTo(leftElements[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}
