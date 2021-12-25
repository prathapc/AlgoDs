package com.practice.B_algo.I_dp;

/**
 * Created by prathapchowdary on 13/12/21.
 *
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class F_LongestPalindromSubstring {
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




    public static String longestPalindromeRecursion(String a) {
        int start =0, end=a.length()-1;

        return longestPalindromeUtil(a, start, end);
    }

    //Time limit exceeded
    private static String longestPalindromeUtil(String a, int start, int end) {
        if(start > end) {
            return "";
        }
        if(isPalindrome(a, start, end)) {
            return a.substring(start, end+1);
        } else {
            String s1 = longestPalindromeUtil(a, start+1, end);
            String s2 = longestPalindromeUtil(a, start, end-1);
            if(s1.length()>s2.length()){
                return s1;
            }
            else{
                return s2;
            }
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
}
