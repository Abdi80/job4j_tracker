package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = Math.min(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() < right.length()) {
            result = -1;
        } else if (result == 0 && left.length() > right.length()) {
            result = 1;
        }
        return result;
    }
}
