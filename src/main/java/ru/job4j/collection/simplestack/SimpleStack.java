package ru.job4j.collection.simplestack;

import ru.job4j.collection.forwardlinked.ForwardLinked;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}
