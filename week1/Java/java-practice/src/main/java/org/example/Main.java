package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Poketmon p = new Poketmon("garden");
//        System.out.println(p.getName());
        AquaPoketmon ap = new AquaPoketmon("garden");
        System.out.println(ap.getName());
        System.out.println(ap.getType());

        Cat c = new Cat();
        Dog d = new Dog();
        c.walll();
        d.walll();
    }
}