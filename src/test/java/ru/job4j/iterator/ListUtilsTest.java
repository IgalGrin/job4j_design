package ru.job4j.iterator;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void removeIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Predicate<Integer> pred = i -> i != 0 && i % 2 == 0;
        ListUtils.removeIf(input, pred);
        assertThat(input, is(Arrays.asList(0, 1, 3, 5)));
    }

    @Test
    public void replaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Predicate<Integer> pred = i -> i != 0 && i % 2 == 0;
        ListUtils.replaceIf(input, pred, 0);
        assertThat(input, is(Arrays.asList(0, 1, 0, 3, 0, 5, 0)));
    }

    @Test
    public void removeAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        List<Integer> elements = new ArrayList<>(Arrays.asList(0, 1, 3, 5));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Arrays.asList(2, 4, 6)));
    }
}