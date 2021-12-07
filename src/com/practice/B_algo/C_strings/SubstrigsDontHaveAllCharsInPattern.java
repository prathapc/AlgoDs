package com.practice.B_algo.C_strings;

/**
 * Created by Prathap on 09 Feb, 2020
 *
 * Input: haystack = "cab", alphabet = ['a', 'c']
 * Output: 4
 * Explanation:
 * We can enumerate all 6 non-empty substrings of `cab`:
 * "c" - this does not have `a`.
 * "a" - this does not have `c`.
 * "ca" - this has every entry in `alphabet`.
 * "b" - this does not have `a` or `c`.
 * "ab" - this does not have `c`.
 * "cab" - this has every entry in `alphabet`.
 * 4 of these substrings don't have every answer, so the function should return 4.
 */
public class SubstrigsDontHaveAllCharsInPattern {

    //problem 1: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
    private static int allSubStringsWithABC(String s) {
        int count[] = {0, 0, 0}, res = 0 , i = 0, n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                --count[s.charAt(i++) - 'a'];
            res += i;
        }
        return res;
    }

    //problem 2:
    private static int allSubstringsWithOutGivenChars(String s, char[] alphabets) {
        int map[] = new int[128];
        int total = alphabets.length;
        int res = 0, start = 0;
        for(char c : alphabets) {
            map[c]++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(map[s.charAt(i)]-- > 0) {
                total--;
            }
            while(total == 0) {
                if(++map[s.charAt(start++)] > 0) {
                    total++;
                }
            }
            res += i-start+1;
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(allSubstringsWithOutGivenChars("cab", new char[]{'a', 'c'}));
    }
}
