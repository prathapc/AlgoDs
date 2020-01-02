package com.practice.leetcode;

/**
 * Created by Prathap on 02 Dec, 2019
 */
public class DecodeWays {
    public static void main(String args[]) {
        String s = "1226";

        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
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
