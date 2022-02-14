package ru.job4j.collection.map;

public class User {
    private String name;
    private int children;
    private int calendarBirthday;

    public User(String name, int children, int calendarBirthday) {
        this.name = name;
        this.children = children;
        this.calendarBirthday = calendarBirthday;
    }

    public User() {
    }
}
