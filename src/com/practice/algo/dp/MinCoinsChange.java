package com.practice.algo.dp;

import java.util.*;

/**
 * Created by Prathap on 30 Jan, 2020
 *
 * https://leetcode.com/problems/coin-change/
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 */
public class MinCoinsChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    dp[i] = dp[i] == -1 ? dp[i - coin] + 1 : Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount];
    }
}
