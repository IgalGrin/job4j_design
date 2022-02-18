package ru.job4j.collection.map;

import java.util.*;

public class SimpleMap<K, V> implements SMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count == capacity * LOAD_FACTOR) {
            expand();
        }
        boolean res = false;
        int i = hash(key.hashCode());
        if (table[i] == null) {
        table[i] = new MapEntry<>(key, value);
        count++;
        modCount++;
        res = true;
        }
        return res;
    }

    private int hash(int hashCode) {
        return indexFor(hashCode ^ hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        table = Arrays.copyOf(table, capacity * 2);
        capacity *= 2;
    }

    public int count() {
        return count;
    }

    @Override
    public V get(K key) {
        MapEntry<K, V> res = table[hash(key.hashCode())];
        return res == null ? null : res.value;
    }

    @Override
    public boolean remove(K key) {
        boolean res = false;
        int i = hash(key.hashCode());
       if (table[i] != null) {
           table[i] = null;
           res = true;
           count--;
           modCount++;
       }
       return res;
    }

    @Override
    public Iterator<K> iterator() {
        int expectedModCount = modCount;
        return new Iterator<>() {
            int pointer = 0;

            @Override
            public boolean hasNext() {
                boolean rsl = pointer < capacity;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (rsl && table[pointer] == null) {
                    pointer++;
                }
                return rsl;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[pointer++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
            return Objects.equals(key, mapEntry.key) && Objects.equals(value, mapEntry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
