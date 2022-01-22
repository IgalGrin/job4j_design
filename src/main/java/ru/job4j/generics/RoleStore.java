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
        if (storage.containsKey(id)) {
            storage.put(id, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (storage.containsKey(id)) {
            storage.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Role findById(String id) {
        if (storage.containsKey(id)) {
            return storage.get(id);
        }
        return null;
    }
}
