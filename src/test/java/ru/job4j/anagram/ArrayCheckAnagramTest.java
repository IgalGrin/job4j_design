package ru.job4j.anagram;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ArrayCheckAnagramTest {
    @Test
    public void whenEq() {
        assertThat(ArrayCheckAnagram.anagrams("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(ArrayCheckAnagram.anagrams("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(ArrayCheckAnagram.anagrams("heloo", "hello"), is(false));
    }
}