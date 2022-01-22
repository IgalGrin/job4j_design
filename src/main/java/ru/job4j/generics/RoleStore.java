package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class RoleStore implements Store<Role> {
    private final Map<String, Role> storage = new HashMap<>();
    @Override
    public void add(Role model) {
        Role v = storage.get(model.getId());
        if (v == null) {
            storage.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, Role model) {
        storage.put(id, model);
        return storage.containsKey(id) ? true : false;
    }

    @Override
    public boolean delete(String id) {
        storage.remove(id);
        return storage.containsKey(id) ? true : false;
    }

    @Override
    public Role findById(String id) {
        return storage.containsKey(id) ? storage.get(id) : null;
    }
}
