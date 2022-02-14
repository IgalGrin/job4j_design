package ru.job4j.collection.map;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private int calendarBirthday;

    public User(String name, int children, int calendarBirthday) {
        this.name = name;
        this.children = children;
        this.calendarBirthday = calendarBirthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", calendarBirthday=" + calendarBirthday
                + '}';
    }

    public static void main(String[] args) {
        User userA = new User("Alex", 2, 180579);
        User userB = new User("Alex", 2, 180579);
        Map<User, Object> map = new HashMap<>();
        map.put(userA, new Object());
        map.put(userB, new Object());
        System.out.println(map);
    }
}
