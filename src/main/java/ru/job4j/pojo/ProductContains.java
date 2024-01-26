package ru.job4j.pojo;

public class ProductContains {
    public static void main(String[] args) {
        Product first = new Product("Milk", 100);
        Product second = new Product("Milk", 100);
        boolean isEqual = first == second;
        System.out.println(isEqual);
        System.out.println(first.equals(second));
    }
}
