package ru.job4j.collection.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    public static void main(String[] args) {
        User userA = new User("Alex", 2,
                new GregorianCalendar(1979, Calendar.MAY, 18));
        User userB = new User("Alex", 2,
                new GregorianCalendar(1979, Calendar.MAY, 18));
        Map<User, Object> map = new HashMap<>();
        map.put(userA, new Object());
        map.put(userB, new Object());
        for (User key : map.keySet()) {
            int hashCode = key.hashCode();
            int hash = Objects.hash(hashCode);
            int index = hash & (16 - 1);
            System.out.println("backet = " + index);
        }
    }
}

