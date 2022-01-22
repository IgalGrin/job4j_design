package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class UserStore implements Store<User> {
    private final Map<String, User> storage = new HashMap<>();
    @Override
    public void add(User model) {
        User v = storage.get(model.getId());
        if (v == null) {
            storage.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, User model) {
        storage.put(id, model);
        return storage.containsKey(id) ? true : false;
    }

    @Override
    public boolean delete(String id) {
        storage.remove(id);
        return storage.containsKey(id) ? true : false;
    }

    @Override
    public User findById(String id) {
        return storage.containsKey(id) ? storage.get(id) : null;
    }
}
