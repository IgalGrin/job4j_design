package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class UserStore implements Store<User> {
    private final Map<String, User> storage = new HashMap<>();
    @Override
    public void add(User model) {
        User v = storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, User model) {
        if (storage.containsKey(id)) {
            storage.put(id, model);
        }
        return storage.containsKey(id) ? true : false;
    }

    @Override
    public boolean delete(String id) {
        storage.remove(id);
        return storage.containsKey(id) ? false : true;
    }

    @Override
    public User findById(String id) {
        return storage.containsKey(id) ? storage.get(id) : null;
    }
}
