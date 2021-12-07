package com.practice.B_algo.C_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 07/11/21.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class A_LongestSubstrWithoutRepeatingChars {
    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> data = new HashMap<>();
        int result=0, count = 0, start = 0;
        for (int i=0; i<s.length(); i++) {
            if (data.containsKey(s.charAt(i))) {
                int lastSeenAt = data.get(s.charAt(i));
                count = i-lastSeenAt;
                while (start <= lastSeenAt) {
                    data.remove(s.charAt(start++));
                }
            } else {
                count++;
            }
            data.put(s.charAt(i), i);
            result = Math.max(result, count);
        }
        return result;
    }
}
