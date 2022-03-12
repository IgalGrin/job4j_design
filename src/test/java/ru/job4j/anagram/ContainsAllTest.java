package ru.job4j.anagram;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContainsAllTest {
    @Test
    public void whenEq() {
        assertThat(ContainsAll.check("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(ContainsAll.check("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(ContainsAll.check("heloo", "hello"), is(false));
    }
}