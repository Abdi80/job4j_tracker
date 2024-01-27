package ru.job4j.format;

import java.util.Calendar;

public class Format {

    public static void getGreeting(String name, int age) {
        System.out.println(String.format("Привет! Я %s, мой возраст: %d", name, age));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Привет, %s! Текущая дата: %tF, Текущее время: %tT", name, instance, instance));
    }

    public static void main(String[] args) {
        getGreeting("Елена", 33);
        getGreetingAndTime("Bob");
        System.out.println(String.format("Number - %.2f", 0.99));
        System.out.println(String.format("%1$,+016.2f", 5000000.000000));
    }
}
