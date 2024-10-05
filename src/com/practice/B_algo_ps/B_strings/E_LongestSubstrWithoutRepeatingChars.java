package com.practice.B_algo_ps.B_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    //beats 87%
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0, left = 0, right = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right))+1);
                //left = map.get(s.charAt(right)) + 1; //fails for "abba" expected: 2 but gives 3 as last a is repeated in prev window and not current
            }
            map.put(s.charAt(right), right);
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }

    public static void main(String args[]) {
        //lengthOfLongestSubstring("ABCBC");
        lengthOfLongestSubstring("abba");
    }

    //solved in 10mins; beats 69%
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> charLastIndexSet = new HashSet<>();
        int result = 0, start = 0;
        for (int i=0; i<s.length(); i++) {
            char currChar = s.charAt(i);
            if (charLastIndexSet.contains(currChar)) {
                while (s.charAt(start) != currChar) {
                    charLastIndexSet.remove(s.charAt(start++));
                }
                charLastIndexSet.remove(s.charAt(start++));
            }
            charLastIndexSet.add(currChar);
            result = Math.max(result, i-start+1);
        }
        return result;
    }



    public static int lengthOfLongestSubstring_1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0, max=0;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() == j-i+1) {
                max = Math.max(max, j-i+1);
            }

            //increment left pointer if duplicate found
            while (map.size() < j-i+1) {
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return max;
    }

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
