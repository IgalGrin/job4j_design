package ru.job4j.generics;

public class Animal {
    private String family;

    public Animal(String family) {
        this.family = family;
    }

    public Animal() {
    }

    public String getFamily() {
        return family;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "family='" + family + '\''
                + '}';
    }
}
