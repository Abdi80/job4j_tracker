package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            if (i >= index) {
                products[i] = i < products.length - 1 ? products[i + 1] : null;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (Product prodact : products) {
            System.out.println(prodact.getName());
        }
        products[1] = products[2];
        products[2] = null;
        for (Product prodact : products) {
            if (prodact != null) {
                System.out.println(prodact.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}