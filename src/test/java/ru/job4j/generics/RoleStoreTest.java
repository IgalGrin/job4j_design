package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void whenAddAndFindThenRoleIsElectrician() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Electrician"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Electrician"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Electrician"));
        Role result = store.findById("12");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRoleIsElectrician() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Electrician"));
        store.add(new Role("1", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Electrician"));
    }

    @Test
    public void whenReplaceThenRoleIsMechanic() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Electrician"));
        store.replace("1", new Role("1", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Mechanic"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Electrician"));
        store.replace("10", new Role("9", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Electrician"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Electrician"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenRoleameIsElectrician() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Electrician"));
        store.delete("8");
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Electrician"));
    }

}