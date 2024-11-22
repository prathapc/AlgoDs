package com.practice.B_algo_ps.I_dp;

import java.util.Arrays;

/**
 * Created by Prathap on 02 Dec, 2019
 *
 * https://leetcode.com/problems/decode-ways/
 *
 * Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or "L"
 * (12).
 */
public class I_DecodeWays {

    public static void main(String args[]) {
        String s = "123";
        System.out.println(decodeWays_topDownDp(s));
        System.out.println(decodeWays_bottomUpDp(s));
    }

    private static int decodeWays_topDownDp(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodings(s, 0, dp);
    }

    private static int numDecodings(String s, int index, int[] dp) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int n = numDecodings(s, index + 1, dp);
        if (index < s.length() - 1 && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))) {
            n += numDecodings(s, index + 2, dp);
        }

        return dp[index] = n;
    }

    public static int decodeWays_bottomUpDp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            int first = Integer.valueOf(s.substring(i, i + 1));
            int second = Integer.valueOf(s.substring(i - 1, i + 1));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                if (i >= 2) {
                    dp[i] += dp[i - 2]; 
                }else {
                    dp[i] += 1;
                }
            }
        }
        return dp[n - 1];
    }
}
