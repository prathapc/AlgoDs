package com.practice.B_algo_ps.B_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 07/11/21.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class E_LongestSubstrWithoutRepeatingChars {
    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int lastDuplicateIndex = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= lastDuplicateIndex) {
                lastDuplicateIndex = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i-lastDuplicateIndex+1);
        }

        return result;
    }
    //take map to store seen characters
    //lastDuplicateIndex variable to track last duplicate char seen
    //keep updating variables while moving forward

    //similar to prev problem - longest substr with atmost k distinct chars
    public int lengthOfLongestSubstring2(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter++;
            map[c1]++;
            end++;

            while (counter > 0) {
                final char c2 = s.charAt(start);
                if (map[c2] > 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}
