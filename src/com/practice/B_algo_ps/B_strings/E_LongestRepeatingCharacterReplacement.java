package com.practice.B_algo_ps.B_strings;

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
public class E_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0, max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            arr[s.charAt(end) - 'A']++;
            max = Math.max(max, arr[s.charAt(end) - 'A']);
            if (end - start + 1 - max > k) {
                arr[s.charAt(start) - 'A']--;
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
    // we are checking if current window end-start+1 - max_in_window is less than k
    // if not increment left pointer
}
