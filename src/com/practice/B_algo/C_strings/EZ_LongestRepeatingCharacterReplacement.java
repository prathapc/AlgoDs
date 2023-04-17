package com.practice.B_algo.C_strings;

/**
 * Created by prathapchowdary on 19/09/22.
 *
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing
 * the above operations.
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class EZ_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] data = new int[26];
        int left = 0, right = 0, result = 0, mostFreqCount = 0;
        while (right < s.length()) {
            ++data[s.charAt(right)-'A'];
            mostFreqCount = Math.max(mostFreqCount, data[s.charAt(right)-'A']);
            if (right-left+1 - mostFreqCount > k) {
                --data[s.charAt(left++) - 'A'];
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
    /**
     * In case anyone is confused by this solution, here's another way of explaining it:
     *
     * end-start+1 = size of the current window
     * maxCount = largest count of a single, unique character in the current window
     *
     * The main equation is: end-start+1-maxCount
     *
     * When end-start+1-maxCount == 0, then then the window is filled with only one character
     * When end-start+1-maxCount > 0, then we have characters in the window that are NOT the character that occurs the most. end-start+1-maxCount is equal to exactly the # of characters that are NOT the character that occurs the most in that window. Example: For a window "xxxyz", end-start+1-maxCount would equal 2. (maxCount is 3 and there are 2 characters here, "y" and "z" that are not "x" in the window.)
     *
     * We are allowed to have at most k replacements in the window, so when end-start+1-maxCount > k, then there are more characters in the window than we can replace, and we need to shrink the window.
     *
     * If we have window with "xxxy" and k = 1, that's fine because end-start+1-maxCount = 1, which is not > k. maxLength gets updated to 4.
     *
     * But if we then find a "z" after, like "xxxyz", then we need to shrink the window because now end-start+1-maxCount = 2, and 2 > 1. The window becomes "xxyz".
     *
     * maxCount may be invalid at some points, but this doesn't matter, because it was valid earlier in the string, and all that matters is finding the max window that occurred anywhere in the string. Additionally, it will expand if and only if enough repeating characters appear in the window to make it expand. So whenever it expands, it's a valid expansion.
     */
}
