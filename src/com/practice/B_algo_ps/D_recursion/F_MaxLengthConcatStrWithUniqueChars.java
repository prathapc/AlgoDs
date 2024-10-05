package com.practice.B_algo_ps.D_recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by prathapchowdary on 24/01/24.
 *
 * You are given an array of strings arr. A string s is formed by the concatenation
 * of a subsequence of arr that has unique characters.
 * Return the maximum possible length of s.
 * A subsequence is an array that can be derived from another array by deleting some
 * or no elements without changing the order of the remaining elements.
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 *
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class F_MaxLengthConcatStrWithUniqueChars {
    int result = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return result;
    }
    private void dfs(List<String> arr, String currStr, int currIndex) {
        boolean isUniqueChar = isUniqueChars(currStr);

        if (isUniqueChar) {
            result = Math.max(currStr.length(), result);
        }

        if (currIndex == arr.size() || !isUniqueChar) {
            return;
        }

        for (int i=currIndex; i<arr.size(); i++) {
            dfs(arr, currStr+arr.get(i), i+1);
        }
    }
    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
