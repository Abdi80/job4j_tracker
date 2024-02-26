package ru.job4j;

public class Box {
    public static void main(String[] args) {
        int a = 1;
        Integer b;
        b = a;
        System.out.println("Integer b = " + b);
        int x = 2;
        num(x);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
        Integer i = 127;
        Integer f = 127;
        System.out.println(i == f);
    }

    public static void num(Integer x) {
        System.out.println("Значение типа Integer: " + x);
    }

    public static void num(int x) {
        System.out.println("Значение типа int: " + x);
    }
}
