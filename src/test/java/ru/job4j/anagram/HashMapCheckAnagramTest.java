package ru.job4j.anagram;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HashMapCheckAnagramTest {
    @Test
    public void whenEq() {
        assertThat(HashMapCheckAnagram.anagram("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(HashMapCheckAnagram.anagram("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(HashMapCheckAnagram.anagram("heloo", "hello"), is(false));
    }
}