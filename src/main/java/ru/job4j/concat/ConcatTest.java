package ru.job4j.concat;

public class ConcatTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuilder string = new StringBuilder("Job4j");
        for (int index = 0; index < 9999; index++) {
            string.append(index);
        }
        System.out.println("Millisecond: " + (System.currentTimeMillis() - startTime));
        StringBuilder builder = new StringBuilder();
        System.out.println(builder.append("1").append("2").append("3"));
        StringBuilder builder1 = new StringBuilder("0");
        System.out.println(builder1.append("1"));
    }

}
