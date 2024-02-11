package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                result = index;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Key not found");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"First", "Second", "Third"};
        String key = "";
        try {
            System.out.println(indexOf(value, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
