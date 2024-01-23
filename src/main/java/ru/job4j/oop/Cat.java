package ru.job4j.oop;

public class Cat {

    private String food;

    private String nick;

    public void show() {
        System.out.println(this.nick + " " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.nick = nick;
    }

    public String sound() {
        return "may-may";
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        System.out.println("It is about Peppy");
        String say = peppy.sound();
        System.out.println(say);
        peppy.giveNick("Peppy");
        peppy.eat("kotleta");
        peppy.show();
        System.out.println("It is about Sparky");
        sparky.giveNick("Sparkly");
        sparky.eat("fish");
        sparky.show();
    }
}
