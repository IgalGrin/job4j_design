package ru.job4j.generics;

public class Tiger extends Predator {
    String name;
    Tiger(String family, String food, String name) {
        super(family, food);
        this.name = name;
    }

    Tiger() {
    }

    @Override
    public String toString() {
        return "Tiger{"
                + "family='" + getFamily() + '\''
                + " food='" + getFood() + '\''
                + " name='" + name + '\''
                + '}';
    }
}
