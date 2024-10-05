package com.practice.B_algo_ps.I_dp;

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
 * https://leetcode.com/problems/coin-change-ii/
 *
 * CoinChange-I -> find min no of coins is classic "DP problem"
 * CoinChange-II -> find total of ways with given coins is classic "knapsack problem"
 */
public class C_CoinChangeII {

    //topDown DP - beats 5%
    public int change(int amount, int[] coins) {
        Map<String, Integer> dp = new HashMap<>();
        return changeUtil(coins, 0, amount, dp);
    }
    private int changeUtil(int[] coins, int index, int amount, Map<String, Integer> dp) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (dp.containsKey(amount + ":" + index)) return dp.get(amount + ":" + index);

        int count = 0;
        for (int i=index; i<coins.length; i++) {
            count += changeUtil(coins, i, amount-coins[i], dp);
        }
        dp.put(amount + ":" + index, count);
        return count;
    }

    //knapsack solution
    public int change_topDownDp(int amount, int[] coins) {
        Map<String, Integer> dp = new HashMap<>();
        return coinChange(coins, 0, amount, dp);
    }
    private int coinChange(int[] coins, int index, int remainAmount, Map<String, Integer> dp) {
        if (index >= coins.length || remainAmount < 0) return 0;
        if (remainAmount == 0) return 1;
        if (dp.containsKey(remainAmount + ":" + index)) return dp.get(remainAmount + ":" + index);

        int res = coinChange(coins, index, remainAmount-coins[index], dp) +
            coinChange(coins, index+1, remainAmount, dp);

        dp.put(remainAmount + ":" + index, res);
        return dp.get(remainAmount + ":" + index);
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
