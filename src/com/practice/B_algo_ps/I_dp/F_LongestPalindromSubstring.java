package com.practice.B_algo_ps.I_dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by prathapchowdary on 13/12/21.
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class F_LongestPalindromSubstring {

    public static void main(String[] args) {
        longestPalindrome_bfs("cbbd");
        longestPalindrome_dfs("cbbd");
    }
    //beats 10.6%
    public static String longestPalindrome_bfs(String s) {
        if (s.length() == 1) return s;
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{0, s.length()-1});
        Set<int[]> notPalindroms = new HashSet<>();
        String maxPalindrom = "";
        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            if (!notPalindroms.contains(curr)) {
                if(isPalindrome(s, curr[0], curr[1])) {
                    if (maxPalindrom.length() < (curr[1]-curr[0]+1)) {
                        maxPalindrom = s.substring(curr[0], curr[1]+1);
                    }
                } else {
                    notPalindroms.add(curr);
                    bfs.add(new int[]{curr[0], curr[1]-1});
                    bfs.add(new int[]{curr[0]+1, curr[1]});
                }
            }
        }
        return maxPalindrom;
    }

    //top down dfs - beats 10.16%
    public static String longestPalindrome_dfs(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        String[][] dp = new String[s.length()][s.length()];
        return longestPalindromeUtil(s, 0, s.length()-1, dp);
    }
    private static String longestPalindromeUtil(String a, int start, int end, String[][] memo) {
        if (start > end) {
            return "";
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        if(isPalindrome(a, start, end)) {
            return a.substring(start, end+1);
        } else {
            String s1 = longestPalindromeUtil(a, start+1, end, memo);
            String s2 = longestPalindromeUtil(a, start, end-1, memo);
            String result = null;
            if (s1 != null && s2 != null) {
                result = s1.length() > s2.length() ? s1 : s2;
            } else if (s1 == null && s2 == null) {
                result = null;
            } else if (s1 == null) {
                result = s2;
            } else {
                result = s1;
            }
            memo[start][end] = result;
            return memo[start][end];
        }
    }
    private static boolean isPalindrome(String a, int start, int end) {
        while(start < end) {
            if(a.charAt(start) != a.charAt(end)) {
                return false;
            }
            start=start+1;
            end=end-1;
        }
        return true;
    }


    public String longestPalindrome(String str) {
        int n = str.length();
        boolean table[][] = new boolean[n][n];

        int palMaxLength = 1;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        int palStart = 0;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                palStart = i;
                palMaxLength = 2;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int start = 0; start < n - k + 1; start++) {
                int end = start + k - 1;
                if (table[start + 1][end - 1] && str.charAt(start) == str.charAt(end)) {
                    table[start][end] = true;

                    if (k > palMaxLength) {
                        palStart = start;
                        palMaxLength = k;
                    }
                }
            }
        }
        return str.substring(palStart, palStart + palMaxLength);
    }
}
