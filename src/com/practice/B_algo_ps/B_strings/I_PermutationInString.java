package com.practice.B_algo_ps.B_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prathapchowdary on 04/11/23.
 *
 * https://leetcode.com/problems/permutation-in-string/
 */
public class I_PermutationInString {

    public static void main(String[] args) {
        //TLE for below input as it generages 3.6M permutations
        System.out.println(checkInclusion_permutations("abcdxabcde", "abcdeabcdx"));

        //optimized without needing computation of permutations
        System.out.println(checkInclusion("adc", "dcda"));
    }

    private static boolean checkInclusion(String s1, String s2) {
        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];

        for (int i=0; i<s1.length(); i++) {
            s1Chars[s1.charAt(i)-'a']++;
        }

        int start = 0, end = 0;
        while (end < s2.length()) {
            s2Chars[s2.charAt(end)-'a']++;
            end++;

            if (Arrays.equals(s1Chars, s2Chars)) return true;

            if (end-start == s1.length()) {
                s2Chars[s2.charAt(start) - 'a']--;
                start++;
            }
        }
        return false;
    }

    public static boolean checkInclusion_permutations(String s1, String s2) {
        List<String> permutations = permutations(s1.toCharArray());
        for (String p : permutations) {
            if (s2.contains(p)) return true;
        }
        return false;
    }
    private static List<String> permutations(char[] s) {
        List<String> permutations = new ArrayList<>();
        permute(s, 0, permutations);
        return permutations;
    }
    private static void permute(char[] s, int index, List<String> permutations) {
        if (index == s.length-1)  {
            permutations.add(String.valueOf(s));
            return;
        }

        for (int i=index; i<s.length; i++) {
            swap(s, i, index);
            permute(s, index+1, permutations);
            swap(s, i, index);
        }
    }
    private static void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }

}
