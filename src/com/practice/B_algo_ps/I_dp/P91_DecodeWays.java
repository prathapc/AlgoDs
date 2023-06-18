package com.practice.B_algo_ps.I_dp;

import java.util.HashMap;
import java.util.Map;

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
        String s = "123";
        System.out.println(decodeWays_topDownDp(s, 0));
        System.out.println(decodeWays_bottomUpDp(s));
    }

    static Map<Integer, Integer> memo = new HashMap<>();
    private static int decodeWays_topDownDp(String s, int index) {
        if (memo.containsKey(index)) return memo.get(index);
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (index == s.length()-1) return 1;

        int ans = decodeWays_topDownDp(s, index+1);
        if (Integer.parseInt(s.substring(index, index+2)) <= 26) {
            ans += decodeWays_topDownDp(s, index+2);
        }
        memo.put(index, ans);
        return ans;
    }

    private static int decodeWays_bottomUpDp(String s) {
        int dp[] = new int[s.length() + 1];
        dp[0] = 1; //just a base case: for empty string only one way of decoding by doing nothing
        dp[1] = s.charAt(0) == '0' ? 0 : 1; //for single char input
        for (int i=2; i<=s.length(); i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigits = Integer.parseInt(s.substring(i-2, i));

            if (oneDigit >= 1) {
                dp[i] = dp[i-1]; //beats 89% where if you put dp[i] = dp[i-1]; it beats only 20%
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
