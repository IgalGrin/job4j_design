package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        T v = storage.get(model.getId());
        if (v == null) {
            storage.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        storage.put(id, model);
        return storage.containsKey(id) ? true : false;
    }

    @Override
    public boolean delete(String id) {
        storage.remove(id);
        return storage.containsKey(id) ? true : false;
    }

    @Override
    public T findById(String id) {
        return storage.containsKey(id) ? storage.get(id) : null;
}
}
