package ru.job4j.oop;

public class Student {
    public void music(String lyrics) {
        System.out.println("I can sing a song : " + lyrics);
    }

    public void sing() {
        System.out.println("La la la");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        String song = "I believe I can fly";
        petya.music(song);
        petya.music(song);
        petya.music(song);
        petya.sing();
        petya.sing();
        petya.sing();
    }
}
