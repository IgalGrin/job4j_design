package ru.job4j.anagram;

import java.util.HashMap;
import java.util.Map;
/**
 O(n) – линейная временная сложность
 */
public class HashMapCheckAnagram {
    public static boolean anagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] word1 = s1.toCharArray();
        char[] word2 = s2.toCharArray();
        Map<Character, Integer> lettersInWord1 = new HashMap<>();
        for (char c : word1) {
            int count = 1;
            if (lettersInWord1.containsKey(c)) {
                count = lettersInWord1.get(c) + 1;
            }
            lettersInWord1.put(c, count);
        }
        for (char c : word2) {
            int count = -1;
            if (lettersInWord1.containsKey(c)) {
                count = lettersInWord1.get(c) - 1;
            }
            lettersInWord1.put(c, count);
        }
        for (char c : lettersInWord1.keySet()) {
            if (lettersInWord1.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
