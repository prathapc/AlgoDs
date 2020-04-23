package com.practice.algo.strings;

import java.util.*;

/**
 * Created by Prathap on 04 Feb, 2020
 *
 * #slidingWindow
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 */
public class FindAllAnagramsInString {

    private static List<Integer> findAnagrams(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
            pCount[(int) (ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // add one more letter
            // on the right side of the window
            sCount[(int) (s.charAt(i) - 'a')]++;
            // remove one letter
            // from the left side of the window
            if (i >= np) {
                sCount[(int) (s.charAt(i - np) - 'a')]--;
            }
            // compare array in the sliding window
            // with the reference array
            if (Arrays.equals(pCount, sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }

    public static void main(String args[]) {
        findAnagrams("cbaebabacd", "abc");
    }
}
