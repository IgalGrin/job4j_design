package ru.job4j.generics;

public class Predator extends Animal {
    private String food;

    public Predator(String family, String food) {
        super(family);
        this.food = food;
    }

    public Predator() {
    }

    public String getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Predator{"
                + "family='" + getFamily() + '\''
                + "food='" + food + '\''
                + '}';
    }
}
