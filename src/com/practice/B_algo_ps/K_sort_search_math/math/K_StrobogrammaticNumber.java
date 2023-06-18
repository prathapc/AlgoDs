package com.practice.B_algo_ps.K_sort_search_math.math;

/**
 * Created by prathapchowdary on 11/06/22.
 *
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Input: num = "69"
 * Output: true
 *
 * https://leetcode.com/problems/strobogrammatic-number/
 */
public class K_StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        StringBuilder rotatedStringBuilder = new StringBuilder();

        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '0' || c == '1' || c == '8') {
                rotatedStringBuilder.append(c);
            } else if (c == '6') {
                rotatedStringBuilder.append('9');
            } else if (c == '9') {
                rotatedStringBuilder.append('6');
            } else { // This must be an invalid digit.
                return false;
            }
        }

        String rotatedString = rotatedStringBuilder.toString();
        return num.equals(rotatedString);
    }
}
