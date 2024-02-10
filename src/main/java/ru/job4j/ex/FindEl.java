package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (key == null) {
            throw new ElementNotFoundException("Key could not be null");
        }
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                result = index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"First", "Second", "Third"};
        String key = null;
        try {
            System.out.println(indexOf(value, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
