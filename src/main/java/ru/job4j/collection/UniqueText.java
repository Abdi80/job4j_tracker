package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = false;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        if (origin.length == text.length) {
            HashSet<String> check = new HashSet<>();
            Collections.addAll(check, origin);
            for (String originWord : check) {
                for (String word : text) {
                    result = false;
                    if (originWord.contains(word)) {
                        result = true;
                        break;
                    }
                }
                if (!result) {
                    break;
                }
            }
        }
        return result;
    }
}
