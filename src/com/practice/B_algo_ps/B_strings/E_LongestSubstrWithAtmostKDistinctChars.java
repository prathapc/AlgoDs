package com.practice.B_algo_ps.B_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 16/11/21.
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters (premium)
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 */
public class E_LongestSubstrWithAtmostKDistinctChars {

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> charFrequency = new HashMap<>();
        int count = 0;    // this value could be optimized by charFrequency.size()
        int maxLen = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);
            charFrequency.put(cRight, charFrequency.getOrDefault(cRight, 0) + 1);
            if (charFrequency.get(cRight) == 1) {
                count++;
            }

            // counter > k means that
            // there are more than k distinct characters in the current window.
            // So we should move the sliding window's left bound.
            while (count > k) {
                char cLeft = s.charAt(left);
                charFrequency.put(cLeft, charFrequency.get(cLeft) - 1);
                if (charFrequency.get(cLeft) == 0) {
                    count--;
                }
                left++;
            }

            //update maxLen
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
