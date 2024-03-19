package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result;
        String[] leftElements = left.split("/", 2);
        String[] rightElements = right.split("/", 2);
        int length = Math.min(leftElements.length, rightElements.length);
        result = rightElements[0].compareTo(leftElements[0]);
        if (result == 0 && length > 1) {
            return leftElements[1].compareTo(rightElements[1]);
        } else if (result == 0) {
            return Integer.compare(leftElements.length, rightElements.length);
        } else {
            return result;
        }
    }
}
