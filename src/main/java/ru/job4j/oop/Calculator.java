package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int h) {
        return sum(h) + this.multiply(h) + minus(h) + this.divide(h);
    }

    public static void main(String[] args) {
        System.out.println(sum(2));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(2));
        System.out.println(minus(2));
        System.out.println(calculator.divide(2));
        System.out.println(calculator.sumAllOperation(2));
    }
}
