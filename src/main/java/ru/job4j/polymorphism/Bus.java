package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Пассажиров в автобусе - ".concat(String.valueOf(passengers)));
    }

    @Override
    public int fillUp(int fuel) {
        int price = 60;
        return fuel * price;
    }
}
