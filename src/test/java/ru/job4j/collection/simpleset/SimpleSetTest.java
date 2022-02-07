package ru.job4j.collection.simpleset;

import static org.junit.Assert.*;
import org.junit.Test;


public class SimpleSetTest {
    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenContainsNonNull() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertFalse(set.contains(4));
        assertFalse(set.contains(5));
        assertTrue(set.contains(3));
    }

    @Test
    public void whenContainsNull() {
        Set<Integer> set = new SimpleSet<>();
        set.add(2);
        set.add(null);
        assertFalse(set.contains(4));
        assertTrue(set.contains(null));
    }
}