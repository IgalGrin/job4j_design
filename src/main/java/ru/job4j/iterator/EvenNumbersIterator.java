package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int pointer = -1;
    private int pointerForNext = -1;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pointer != indexWithEven();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        pointer = pointerForNext;
        return data[pointer];
    }

    public int indexWithEven() {
        for (int i = pointer + 1; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                pointerForNext = i;
                break;
            }
        }
        return pointerForNext;
    }
}