package com.practice.B_algo_ps.B_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by prathapchowdary on 10/06/22.
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class B_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map.get(s.charAt(i))) return false;
            } else {
                if (mappedChars.contains(t.charAt(i))) return false;
            }
            mappedChars.add(t.charAt(i));
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
