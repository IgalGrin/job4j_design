package ru.job4j.anagram;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CycleCheckAnagramTest {
    @Test
    public void whenEq() {
        assertThat(CycleCheckAnagram.anagr("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(CycleCheckAnagram.anagr("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(CycleCheckAnagram.anagr("heloo", "hello"), is(false));
    }
}