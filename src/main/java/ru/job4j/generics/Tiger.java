package ru.job4j.generics;

public class Tiger extends Predator {
    String family = "cat";
    Tiger(String name, String food, String family) {
        super(name, food);
        this.family = family;
    }

    Tiger() {
    }

    @Override
    public String toString() {
        return "Tiger{"
                + "name='" + getName() + '\''
                + "food='" + getFood() + '\''
                + "family='" + family + '\''
                + '}';
    }
}
