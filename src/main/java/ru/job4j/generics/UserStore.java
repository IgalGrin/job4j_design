package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class UserStore implements Store<User> {
    private final Map<String, User> storage = new HashMap<>();
    @Override
    public void add(User model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, User model) {
        return storage.replace(id, storage.get(id), model);
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id, storage.get(id));
    }

    @Override
    public User findById(String id) {
        return storage.get(id);
    }

}
