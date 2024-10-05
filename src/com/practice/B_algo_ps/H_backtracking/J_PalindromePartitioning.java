package com.practice.B_algo_ps.H_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 29/06/23.
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class J_PalindromePartitioning {
    List<List<String>> result = null;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return result;
    }
    private void dfs(String s, int index, List<String> temp) {
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index; i<s.length(); i++) {
            if (!isPalindrome(s.substring(index, i+1))) continue;
            temp.add(s.substring(index, i+1));
            dfs(s, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
