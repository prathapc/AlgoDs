package com.practice.B_algo_ps.B_strings;

/**
 * Created by prathapchowdary on 29/05/23.
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 *  https://leetcode.com/problems/greatest-common-divisor-of-strings
 *  #leetcode75
 */
public class H_GreatestCommonDivisorOfStrings {
    public boolean valid(String str1, String str2, int k) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 % k > 0 || len2 % k > 0) {
            return false;
        } else {
            String base = str1.substring(0, k);
            return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
        }
    }


    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }
}
