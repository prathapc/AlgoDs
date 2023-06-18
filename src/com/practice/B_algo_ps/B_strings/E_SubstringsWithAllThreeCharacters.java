package com.practice.B_algo_ps.B_strings;

/**
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 *
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 */
public class E_SubstringsWithAllThreeCharacters {

    private static int allSubStringsWithABC(String s) {
        int[] track = new int[3]; //also we can use 3 variables for counting (a, b, c)
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            track[s.charAt(i) - 'a']++;

            while (track[0] > 0 && track[1] > 0 && track[2] > 0) {
                //we are doing res += s.length() - i; because if a substring x has at least one a, one b, and one c,
                // then every possible longer substring with x as the start also has at least one a, one b, and one c.
                res += s.length() - i;
                track[s.charAt(left++) - 'a']--;
            }
        }
        return res;
    }
}
