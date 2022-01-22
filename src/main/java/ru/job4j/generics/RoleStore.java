package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class RoleStore implements Store<Role> {
    private final Map<String, Role> storage = new HashMap<>();
    @Override
    public void add(Role model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, Role model) {
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
    public Role findById(String id) {
        return storage.containsKey(id) ? storage.get(id) : null;
    }
}
