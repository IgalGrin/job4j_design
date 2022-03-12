package ru.job4j.anagram;

import java.util.Arrays;
/**
 *  O(n log n) из-за сортировки массива
 */
public class ArrayCheckAnagram {
    public static boolean anagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] word1 = s1.toCharArray();
        char[] word2 = s2.toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
}
