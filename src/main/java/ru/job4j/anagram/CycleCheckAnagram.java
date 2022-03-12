package ru.job4j.anagram;

/**
 * O(n) – линейная временная сложность
 */
public class CycleCheckAnagram {
    public static boolean anagr(String s1, String s2) {
        int value = 0;
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            value += (int) s1.charAt(i);
            value -= (int) s2.charAt(i);
        }
        return value == 0;
    }
}
