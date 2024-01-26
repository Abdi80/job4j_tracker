package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 464);
        Book green = new Book("Green book", 500);
        Book yelow = new Book("Yelow book", 600);
        Book black = new Book("Black book", 450);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = green;
        books[2] = yelow;
        books[3] = black;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " quantity pages - " + books[index].getPages());
        }
        System.out.println("Replace index 0 to 3");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " quantity pages - " + book.getPages());
        }
        System.out.println("Search Clean code");
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " quantity pages - " + book.getPages());
            }
        }

    }
}
