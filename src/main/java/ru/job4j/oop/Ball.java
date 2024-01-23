package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition) {
        String message = condition ? "Ball have been eaten" : "Ball escaped";
        System.out.println(message);
    }
}
