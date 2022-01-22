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
        return storage.replace(id, storage.get(id), model);
    }

    @Override
    public boolean delete(String id) {
        return storage.remove(id, storage.get(id));
    }

    @Override
    public Role findById(String id) {
        return storage.get(id);
    }
}
