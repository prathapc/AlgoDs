package com.practice.B_algo_ps.I_dp;

import java.util.*;

/**
 * Created by Prathap on 30 Jan, 2020
 *
 * Return the fewest number of coins that you need to make up that amount from infinite supply of coins.
 *
 * https://leetcode.com/problems/coin-change/
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 */
public class C_CoinChange {

    //recursion with memo
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        return coinChange(coins, amount, dp);
    }
    private int coinChange(int[] coins, int remain, Map<Integer, Integer> dp) {
        if (remain == 0) return 0;
        if (remain < 0) return -1;

        if (dp.containsKey(remain)) {
            return dp.get(remain);
        }

        int minCount = -1;
        for (int coin : coins) {
            int count = coinChange(coins, remain-coin, dp);
            if (count >= 0) {
                minCount = minCount<0?count+1:Math.min(count+1, minCount);
            }
        }
        dp.put(remain, minCount);
        return dp.get(remain);
    }

    //bfs solution
    public int coinChange_bfs(int[] coins, int amount) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int cs = 0;
        boolean[] vstd = new boolean[amount+1];
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0;i<n;i++) {
                int sum = q.poll();
                if(sum==amount) {
                    return cs;
                }
                if(sum>amount || vstd[sum]) {
                    continue;
                }
                vstd[sum]=true;
                for(int coin:coins) {
                    q.add(sum+coin);
                }
            }
            cs++;
        }
        return -1;
    }


    //Another method: bottom up DP
    public int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    dp[i] = dp[i]==-1 ? dp[i-coin]+1 : Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        return dp[amount];
    }
}
