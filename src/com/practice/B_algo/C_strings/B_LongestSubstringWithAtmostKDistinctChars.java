package com.practice.B_algo.C_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 16/11/21.
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 */
public class B_LongestSubstringWithAtmostKDistinctChars {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        int start = 0, end = 0, unique = 0, result = 0;
        Map<Character, Integer> data = new HashMap<>();
        //move end until you reach end of string and keep adding uniques and compare with given k
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (data.containsKey(ch)) {
                data.put(ch, data.get(ch)+1);
            } else {
                unique++;
                data.put(ch, 1);
            }

            //once unique count crosses k, need to remove chars from start
            while (unique > k) {
                char startCh = s.charAt(start);
                if (data.get(startCh) > 1) {
                    data.put(startCh, data.get(startCh)-1);
                } else {
                    data.remove(startCh);
                    unique--;
                }
                start++;
            }

            //update result
            result = Math.max(result, end-start+1);

            end++;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstringKDistinct("aba", 1));
    }
}
