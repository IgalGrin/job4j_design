package ru.job4j.collection.simpleset;

import ru.job4j.collection.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(5);

    @Override
    public boolean add(T value) {
        boolean add = !contains(value);
        if (add) {
        set.add(value);
        }
        return add;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
                for (T s : set) {
            if (Objects.equals(s, value)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
