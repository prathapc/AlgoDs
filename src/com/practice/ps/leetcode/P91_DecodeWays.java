package com.practice.ps.leetcode;

/**
 * Created by Prathap on 02 Dec, 2019
 *
 * https://leetcode.com/problems/decode-ways/
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 */
public class P91_DecodeWays {
    public static void main(String args[]) {
        String s = "01";

        int dp[] = new int[s.length() + 1];
        dp[0] = 1; //just a base case: for empty string only one way of decoding by doing nothing
        dp[1] = s.charAt(0) == '0' ? 0 : 1; //for single char input
        for (int i=2; i<=s.length(); i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigits = Integer.parseInt(s.substring(i-2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i-1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i-2];
            }
        }

        System.out.println(dp[s.length()]);
    }
}
