package ru.job4j.collection.simplequeue;

import ru.job4j.collection.simplestack.SimpleStack;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private int inCount;
    private int outCount;
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (inCount == 0) {
            throw new NoSuchElementException();
        }
        while (outCount <= inCount) {
            out.push(in.pop());
            outCount++;
            inCount--;
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inCount++;
    }
}
