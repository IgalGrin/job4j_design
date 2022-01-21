package ru.job4j.generics;

public class Predator extends Animal {
    private String food;

    public Predator(String name, String food) {
        super(name);
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
                + "name='" + getName() + '\''
                + "food='" + food + '\''
                + '}';
    }
}
