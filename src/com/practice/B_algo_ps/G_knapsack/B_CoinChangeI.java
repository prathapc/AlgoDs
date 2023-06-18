package com.practice.B_algo_ps.G_knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Return the fewest number of coins that you need to make up that amount from infinite supply of coins.
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * https://leetcode.com/problems/coin-change/
 */
public class B_CoinChangeI {
	
	//1,2,3 cent coins available with unlimited supply; need change for "n" using these coins
	public static void main(String[] args) {
		//int sum = 10;
		//int coins[] = {2,5,3,6};
		int sum = 35;
		int[] coins = {3,5,10};

		System.out.println(fewerCoinCount(coins, sum));

		Map<Integer, Integer> data = new HashMap<>();
		System.out.println(fewerCoinCount_dp(coins, sum, data));

		System.out.println(fewerCoinCount_dp(coins, sum));
	}

	//recursion -  O(S^n) where S is sum and n is no of coins
	private static int fewerCoinCount(int[] coins, int remain) {
		if (remain == 0) return 0;
		if (remain < 0) return -1;

		int minCount = Integer.MAX_VALUE;
		for (int coin : coins) {
			int temp = fewerCoinCount(coins, remain-coin);
			if (temp == -1) continue;
			minCount = Math.min(minCount, temp+1);
		}
		return minCount == Integer.MAX_VALUE ? -1 : minCount;
	}

	//top down DP - beats 5%
	private static int fewerCoinCount_dp(int[] coins, int remain, Map<Integer, Integer> data) {
		if (remain == 0) return 0;
		if (remain < 0) return -1;

		if (data.containsKey(remain)) {
			return data.get(remain);
		}
		int minCount = Integer.MAX_VALUE;
		for (int coin : coins) {
			int temp = fewerCoinCount_dp(coins, remain-coin, data);
			if (temp == -1) continue;
			minCount = Math.min(minCount, temp+1);
		}
		minCount = minCount == Integer.MAX_VALUE ? -1 : minCount;
		data.put(remain, minCount);
		return minCount;
	}

	//bottom up DP - beats 93% - O(S*n)
	private static int fewerCoinCount_dp(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount+1); //can take Integer.MAX_VALUE as default well
		dp[0] = 0;
		for (int i=1; i<=amount; i++) {
			for (int coin : coins) {
				if (i-coin < 0) continue;
				dp[i] = Math.min(dp[i], dp[i-coin] + 1);
			}
		}
		return dp[amount] == amount+1 ? -1 : dp[amount];
	}
}
