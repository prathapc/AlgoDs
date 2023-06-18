package com.practice.B_algo_ps.G_knapsack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 30/04/22.
 *
 * Return the number of combinations that make up that amount
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * https://leetcode.com/problems/coin-change-2/
 */
public class B_CoinChangeII {

    public int change(int amount, int[] coins) {
        Map<String, Integer> data = new HashMap<>();
        return change_dp(coins, amount, coins.length-1, data);
    }

    //top down DP - beats 6%
    private int change_dp(int[] coins, int amount, int index, Map<String, Integer> data) {
        if (index < 0 || amount < 0) return 0;
        if (amount == 0) return 1;

        String key = index + ":" + amount;
        if (data.containsKey(key)) {
            return data.get(key);
        }

        int res = 0;
        // is it possible to build amount using only this current coin?
        res += change_dp(coins, amount-coins[index], index, data);

        // is it possible to build amount using another coins?
        res += change_dp(coins, amount, index-1, data);

        data.put(key, res);
        return res;
    }

    //bottom up DP - beats 70%
    private static int change_dp(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; x++) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }


}
