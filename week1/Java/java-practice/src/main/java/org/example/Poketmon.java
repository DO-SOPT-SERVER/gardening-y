package org.example;

public abstract class Poketmon {
    private String name;
    private PoketmonType type;

    public Poketmon(String name) {
        this.name = name;
        System.out.println("hello, "+name);
    }

    public Poketmon(String name, PoketmonType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PoketmonType getType() {
        return type;
    }

    public void setType(PoketmonType type) {
        this.type = type;
    }
}
