package ru.job4j.anagram;

import java.util.ArrayList;
import java.util.List;
/**
 O(n) – линейная временная сложность
 */
public class ContainsAll {
    public static Object check(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        List<Character> list = new ArrayList<>();
        for (Character ch : left.toCharArray()) {
            list.add(ch);
        }
        for (Character ch : right.toCharArray()) {
            list.remove(ch);
        }
        return list.isEmpty();
    }
}
